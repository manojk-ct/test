(function (){
    "use strict";

angular.module('app.provider')
        .controller('ProviderController',ProviderController)
        .controller('ProviderAddController',ProviderAddController)
        .controller('ProviderEditController',ProviderEditController)
        .controller('ProviderViewController',ProviderViewController);


ProviderController.$inject =['$scope','sessionService','$state','providerService','$filter','CONSTANT','countryService','stateService','facilityListService','logger','$log'];
ProviderAddController.$inject =['$scope','sessionService','$state','providerService','CONSTANT','countryService','stateService','facilityListService','Notification'];
ProviderEditController.$inject =['$scope','sessionService','$state','providerService','CONSTANT','countryService','stateService','$stateParams','facilityListService','Notification'];
ProviderViewController.$inject =['$scope','sessionService','$state','providerService','CONSTANT','countryService','stateService','$stateParams','facilityListService','Notification'];


function ProviderController($scope,sessionService,$state,providerService,$filter,CONSTANT,countryService,stateService,facilityListService,logger,$log){
    $log.info("provider controller initiated");
    var init;
    var getFacility;
    var isLoggedIn= sessionService.isLoggedIn();
    $scope.constant = CONSTANT;
    $scope.countryService =countryService;
    $scope.providers=[];
    $scope.currentTabMain =true;
    $scope.readStatus = false;
    $scope.formValidStatus=false;
    $scope.currentTab ="listProvider.html";
    var tempProvider={};
    var tempIndex;
    $scope.showSpinner = true;
    // To get list of providers
    providerService.query().$promise.then(function (data){
        $scope.providers = data;
        $scope.showSpinner = false;
        $log.debug("ProviderController: Successfully get the list of Providers");
        init();
       getFacility();
    }).catch(function (error){
        $scope.showSpinner = false;
         throw new Error(error.statusText);
         $log.error("ProviderController: " + error.statusText); 
    });
    
    // To get add provider page
    $scope.onClickAdd = function (){
        $log.debug("ProviderController: on-click of add provider");
        $scope.page ="Add";
        $scope.currentTabMain =false;
        $scope.currentTab ="addProviderDetails.html";
        $scope.provider ={};
        $scope.readStatus = false;
        $scope.formValidStatus=false;
    };
    
    // To get edit provider page
    $scope.onClickEdit =function (index){
        $log.debug("ProviderController: on-click of edit provider");
        $scope.page ="Edit";
        $scope.currentTabMain =false;
        $scope.currentTab ="addProviderDetails.html";
        $scope.provider = $scope.currentPageProviders[index];
        tempProvider = angular.copy($scope.currentPageProviders[index]);
        tempIndex = index;
        $scope.readStatus = false;
        $scope.formValidStatus=false; 
        $scope.updateIndex = index;
        $scope.GetStates();
        getFacility();
    };
    
    // To get view provider
    $scope.onClickView =function (index){
        $log.debug("ProviderController: on-click of view provider");
        $scope.page ="View";
        $scope.currentTabMain =false;
        $scope.currentTab ="addProviderDetails.html";
        $scope.provider = $scope.currentPageProviders[index];
        tempProvider = angular.copy($scope.currentPageProviders[index]);
        tempIndex = index;
        $scope.readStatus = true;
        $scope.formValidStatus=false;
        $scope.GetStates();
        getFacility();
    };
    
    // To get back to list of provider page
    $scope.onClickList = function (){
        $scope.currentPageProviders[tempIndex] = tempProvider;
        $scope.currentTabMain =true;
    };
    
    // To delete provider
    $scope.deleteProvider = function (index){
        var provider = $scope.providers[index];  
        providerService.delete({providerId: provider.providerId}).$promise.then(function(data){
                $log.debug("ProviderController: successfully deleted provider");
                $scope.providers.splice(index, 1);
                logger.logSuccess('Successfully deleted  provider');
                init();
        }).catch(function (error){
             throw new Error(error.statusText);
             $log.error("ProviderController: " + error.statusText); 
        });
    };
    
    // To get states
    $scope.GetStates = function (){      
        if($scope.provider.countryId === undefined)
        {
            logger.logError('Please select the country');
        }else{
             stateService.query({country_id:$scope.provider.countryId}).$promise.then(function(response){
                $scope.states =response;
                $log.debug("ProviderController: Successfully get the list of states");
            }).catch(function (error){
                 throw new Error(error.statusText);
                 $log.error("ProviderController: " + error.statusText); 
            });
        }
    };
    
    // To get list of facility
    var getFacility = function (){
      facilityListService.getFacility().$promise.then(function (data){
          $log.debug("ProviderController: Successfully get the list of Facilities");
           $scope.facilityList =  data;
        }).catch(function (error){
             throw new Error(error.statusText);
             $log.error("ProviderController: " + error.statusText); 
        });  
    };
    
    // To save provider
    $scope.Submit = function (providerStatus){
        if(!providerStatus)
        {
            $scope.formValidStatus=true;
            $log.debug("ProviderController: form data is not valid");
            logger.logError("Please fill the required field");
        }
        else{
            $scope.formValidStatus=false;
                if($scope.page === "Add"){
                providerService.save($scope.provider).$promise.then(function (data){
                    if(data !== null)
                    {
                        $scope.providers.push(data);
                        $log.debug("ProviderController: successfully added new provider");
                        logger.logSuccess('Successfully added provider');
                        $scope.currentTab ="listProvider.html";
                        $scope.currentTabMain =true;
                        init();
                    }
                }).catch(function (error){
                     throw new Error(error.statusText);
                     $log.error("ProviderController: " + error.statusText); 
                });
            }else if($scope.page === "Edit"){
                providerService.update($scope.provider).$promise.then(function (){                    
                    logger.logSuccess('Successfully updated Provider ');
                    if($scope.updateIndex !== null)
                    {
                        $log.debug("ProviderController: successfully updated provider");
                        $scope.providers[$scope.updateIndex] =  $scope.provider;
                        $scope.updateIndex = null;
                        $scope.currentTab ="listProvider.html";
                        $scope.currentTabMain =true;
                    }     
                }).catch(function (error){
                     throw new Error(error.statusText);
                     $log.error("ProviderController: " + error.statusText); 
                });
            }
        }
        
    };
    
    // Pagination
    $scope.searchKeywords = '';
    $scope.filteredProviders = [];
    $scope.row = '';
    $scope.select = function(page) {
        var end, start;
        start = (page - 1) * $scope.numPerPage;
        end = start + $scope.numPerPage;
        return $scope.currentPageProviders = $scope.filteredProviders.slice(start, end);
    };
    $scope.onFilterChange = function() {
        $scope.select(1);
        $scope.currentPage = 1;
        return $scope.row = '';
    };
    $scope.onNumPerPageChange = function() {
        $scope.select(1);
        return $scope.currentPage = 1;
    };
    $scope.onOrderChange = function() {
        $scope.select(1);
        return $scope.currentPage = 1;
    };
    $scope.search = function() {
        $scope.filteredProviders = $filter('filter')($scope.providers, $scope.searchKeywords);
        return $scope.onFilterChange();
    };
    $scope.order = function(rowName) {
        if ($scope.row === rowName) {
          return;
        }
        $scope.row = rowName;
        $scope.filteredProviders = $filter('orderBy')($scope.providers, rowName);
        return $scope.onOrderChange();
    };
    $scope.numPerPageOpt = [3, 5, 10, 20];
    $scope.numPerPage = $scope.numPerPageOpt[1];
    $scope.currentPage = 1;
    $scope.currentPageProviders = [];
    init = function() {
        $scope.search();
        return $scope.select($scope.currentPage);
    };
    return init();
};

function ProviderAddController($scope,sessionService,$state,providerService,CONSTANT,countryService,stateService,facilityListService,Notification){
    $scope.constant = CONSTANT;
    $scope.countryService =countryService;
    $scope.page ="Add";
    $scope.readStatus = false;
    $scope.formValidStatus=false;
    
    facilityListService.getFacility(function (data){
           $scope.facilityList =  data;
        },function (){
            
    });
    $scope.GetStates = function (){      
        stateService.query({country_id:$scope.provider.country}
            ,function(response){
                $scope.states =response;
            },function (){
            });
    };
    
    $scope.Submit = function (providerStatus){
        if(!providerStatus)
        {
            $scope.formValidStatus=true;
            alert('You have missed somthing');
        }
        else{
            if($scope.provider.pecosEnrolled === "Yes")
            {
                $scope.provider.pecosEnrolled = true;
            }
            else
            {
                $scope.provider.pecosEnrolled =false;
            }
                providerService.save($scope.provider,function (data){
//                    logger.logSuccess('Successfully added ');
                    $state.go('manageProvider');
                },function (error){
                    alert('Data is not stored');
                });
        }
        
    };
};

function ProviderEditController($scope,sessionService,$state,providerService,CONSTANT,countryService,stateService,$stateParams,facilityListService,Notification){
    $scope.constant = CONSTANT;
    $scope.countryService =countryService;
    $scope.page ="Edit";
    $scope.readStatus = false;
    $scope.formValidStatus=false;
    var init;
    var providerId = $stateParams.providerId;
    providerService.get({providerId:providerId},function (providerData){
            if(providerData.pecosEnrolled === true)
            {
                providerData.pecosEnrolled ="Yes";
                
            }
            else {
                 providerData.pecosEnrolled ="No";
            }
           $scope.provider = providerData;
           init();
            
       },function (error){
           alert('Somthing went wrong please try again');
    });
    
    $scope.GetStates = function (){      
        
        stateService.query({country_id:$scope.provider.country}
            ,function(response){
                $scope.states =response;
            },function (){
            });
    };
    
    $scope.Submit = function (providerStatus){
        if(!providerStatus)
        {
            $scope.formValidStatus=true;
            alert('You have missed somthing');
        }
        else{
            if($scope.provider.pecosEnrolled === "Yes")
            {
                $scope.provider.pecosEnrolled = true;
            }
            else
            {
                $scope.provider.pecosEnrolled =false;
            }
            $scope.provider.$update(function (data){
//                     logger.logSuccess('Successfully edited ');
                    $state.go('manageProvider');
                },function (error){
                    alert('Data is not stored');
                });
        }
        
    };
    
    init = function (){
        facilityListService.getFacility(function (data){
           $scope.facilityList =  data;
        },function (){
            
        });
        
        $scope.provider.country=1;
        stateService.query({country_id:$scope.provider.country},function(response){
            $scope.states =response;
        },function (){
        });
    };
};

function ProviderViewController($scope,sessionService,$state,providerService,CONSTANT,countryService,stateService,$stateParams,facilityListService,Notification){
        $scope.constant = CONSTANT;
        $scope.countryService =countryService;
        $scope.page ="View";
         var init;
        $scope.readStatus = true;
        var providerId = $stateParams.providerId;
        providerService.get({providerId:providerId},function (providerData){
            if(providerData.pecosEnrolled === true)
            {
                providerData.pecosEnrolled ="Yes";
                
            }
            else {
                 providerData.pecosEnrolled ="No";
            }
           $scope.provider = providerData;
           init();
        },function (error){
           alert('Somthing went wrong please try again');
        });
        init = function (){        
             facilityListService.getFacility(function (data){
                $scope.facilityList =  data;
            },function (){
            
            });
            $scope.provider.country=1;
            stateService.query({country_id:$scope.provider.country},function(response){
                $scope.states =response;
            },function (){
            });
            
        };
};

})();
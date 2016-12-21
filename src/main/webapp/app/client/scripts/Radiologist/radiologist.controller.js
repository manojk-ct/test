(function (){
    "use strict";

angular.module('app.radiologist')
        .controller('RadiologistController',RadiologistController)
        .controller('RadiologistAddController',RadiologistAddController)
        .controller('RadiologistEditController',RadiologistEditController)
        .controller('RadiologistViewController',RadiologistViewController)
        .controller('RadiologistGroupController',RadiologistGroupController);

RadiologistController.$inject =['$scope','sessionService','$state','radiologistService','$filter','CONSTANT','countryService','stateService','logger','$log'];
RadiologistAddController.$inject =['$scope','sessionService','$state','radiologistService','CONSTANT','countryService','stateService','Notification'];
RadiologistEditController.$inject =['$scope','sessionService','$state','radiologistService','$stateParams','CONSTANT','countryService','stateService','Notification'];
RadiologistViewController.$inject =['$scope','sessionService','$state','radiologistService','$stateParams','CONSTANT','countryService','stateService','Notification'];
RadiologistGroupController.$inject =['$scope','sessionService','$state','radiologistService'];

function RadiologistController($scope,sessionService,$state,radiologistService,$filter,CONSTANT,countryService,stateService,logger,$log){
    $log.info("Radiologist controller initiated");
    var init;
    var isLoggedIn= sessionService.isLoggedIn();
    $scope.radiologists=[];
    $scope.constant = CONSTANT;
    $scope.countryService =countryService;
    $scope.currentTab ="listRadiologist.html";
    $scope.currentTabMain = true;
    $scope.readStatus = false;
    $scope.formValidStatus=false;
    $scope.updateIndex= null;
    $scope. radiologistGroups =[{radiologistGroupId:1,radiologistGroupName:'Group1'}];
    var tempRadiologist={};
    var tempIndex;
    $scope.showSpinner = true;
    // To get list of radiologist
    radiologistService.query().$promise.then(function (data){
        $scope.showSpinner = false;
        $scope.radiologists = data;
        $log.debug("RadiologistController: Successfully get the list of Radiologist");
        init();
       
    }).catch(function (error){
        $scope.showSpinner = false;
        throw new Error(error.statusText);
        $log.error("RadiologistController: " + error.statusText); 
    });
    
    // To get add radiologist
    $scope.onClickAdd = function (){
        $log.debug("RadiologistController: on-click of add radiologist");
        $scope.page ="Add";
        $scope.currentTabMain = false;
        $scope.currentTab ="addRadiologistDetails.html";
        $scope.radiologist ={};
        $scope.readStatus = false;
        $scope.formValidStatus=false;
    };
    
    // To get edit radiologist
    $scope.onClickEdit =function (index){
        $log.debug("RadiologistController: on-click of edit radiologist");
        $scope.page ="Edit";
        $scope.currentTabMain = false;
        $scope.currentTab ="addRadiologistDetails.html";
        $scope.radiologist = $scope.currentPageRadiologists[index];
        tempRadiologist = angular.copy($scope.currentPageRadiologists[index]);
        tempIndex = index;
        $scope.readStatus = false;
        $scope.formValidStatus=false; 
        $scope.updateIndex = index;
        $scope.GetStates();
    };
    
    // To get view radiologist
    $scope.onClickView =function (index){
        $log.debug("RadiologistController: on-click of view radiologist");
        $scope.page ="View";
        $scope.currentTabMain = false;
        $scope.currentTab ="addRadiologistDetails.html";
        $scope.radiologist = $scope.currentPageRadiologists[index];
        tempRadiologist = angular.copy($scope.currentPageRadiologists[index]);
        tempIndex = index;
        $scope.readStatus = true;
        $scope.formValidStatus=false;
        $scope.GetStates();
    };
    
    // To get back to list of radiologist 
    $scope.onClickList = function (){
        $scope.currentPageRadiologists[tempIndex] = tempRadiologist;
        $scope.currentTab ="listRadiologist.html";
        $scope.currentTabMain = true;
    };
    
    // To get states
    $scope.GetStates = function (){    
        if($scope.radiologist.countryId === undefined)
        {
            logger.logError('Please select the country');
        }else{
            stateService.query({country_id:$scope.radiologist.countryId}).$promise.then(function(response){
                $scope.states =response;
                $log.debug("RadiologistController: Successfully get the list of states");
            }).catch(function (error){
                 throw new Error(error.statusText);
                 $log.error("RadiologistController: " + error.statusText); 
            });
        }
        
    };  
    
    // To delete radiologist
    $scope.deleteRadiologist = function (index){
        var radiologist = $scope.radiologists[index];  
        radiologistService.delete({radiologistId: radiologist.radiologistId}).$promise.then(function(){
            $log.debug("RadiologistController: successfully deleted radiologist");
            $scope.radiologists.splice(index, 1);
              logger.logSuccess('Successfully deleted ');
              init();
        }).catch(function (error){
             throw new Error(error.statusText);
             $log.error("RadiologistController: " + error.statusText); 
        });
    };
    
    // To save radiologist
    $scope.Submit = function (radiologistStatus){
        if(!radiologistStatus)
        {
            $scope.formValidStatus=true;
             $log.debug("RadiologistController: form data is not valid");
            logger.logError("Please fill the required field");
        }
        else{
                $scope.formValidStatus=false;
                if($scope.page === "Add"){
                    radiologistService.save($scope.radiologist).$promise.then(function (data){
                        if(data !== null)
                        {
                            $log.debug("RadiologistController: successfully added new radiologist");
                            $scope.radiologists.push(data);
                            logger.logSuccess('Successfully added ');
                            $scope.currentTab ="listRadiologist.html";
                            $scope.currentTabMain = true;
                            init();
                        }
                    }).catch(function (error){
                         throw new Error(error.statusText);
                         $log.error("RadiologistController: " + error.statusText); 
                    });
                }else if($scope.page === "Edit"){
                    radiologistService.update($scope.radiologist).$promise.then(function (data){
                        if($scope.updateIndex !== null)
                        {
                            $log.debug("RadiologistController: successfully updated radiologist");
                            $scope.radiologists[$scope.updateIndex] =  $scope.radiologist;
                            $scope.updateIndex = null;
                        }   
                        logger.logSuccess('Successfully edited ');
                        $scope.currentTab ="listRadiologist.html";
                        $scope.currentTabMain = true;
                        init();
                    }).catch(function (error){
                         throw new Error(error.statusText);
                         $log.error("RadiologistController: " + error.statusText); 
                    });
                }
               
        }
        
    };
    
    // Pagination
    $scope.searchKeywords = '';
    $scope.filteredRadiologists = [];
    $scope.row = '';
    $scope.select = function(page) {
        var end, start;
        start = (page - 1) * $scope.numPerPage;
        end = start + $scope.numPerPage;
        return $scope.currentPageRadiologists = $scope.filteredRadiologists.slice(start, end);
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
        $scope.filteredRadiologists = $filter('filter')($scope.radiologists, $scope.searchKeywords);
        return $scope.onFilterChange();
    };
    $scope.order = function(rowName) {
        if ($scope.row === rowName) {
          return;
        }
        $scope.row = rowName;
        $scope.filteredRadiologists = $filter('orderBy')($scope.radiologists, rowName);
        return $scope.onOrderChange();
    };
    $scope.numPerPageOpt = [3, 5, 10, 20];
    $scope.numPerPage = $scope.numPerPageOpt[1];
    $scope.currentPage = 1;
    $scope.currentPageRadiologists = [];
    init = function() {
        $scope.search();
        return $scope.select($scope.currentPage);
    };
    return init();
};

function RadiologistAddController($scope,sessionService,$state,radiologistService,CONSTANT,countryService,stateService,Notification){
    $scope.page ="Add";
        $scope.constant = CONSTANT;
    $scope.countryService =countryService;
    $scope.readStatus = false;  
    $scope.formValidStatus=false;
    
    $scope. radiologistGroups =[{radiologistGroupId:1,radiologistGroupName:'Group1'}];
    $scope.Submit = function (radiologistStatus){
        if(!radiologistStatus)
        {
            $scope.formValidStatus=true;
            alert('You have missed somthing');
        }
        else{
                radiologistService.save($scope.radiologist,function (data){
//                    logger.logSuccess('Successfully added ');
                    $state.go('manageRadiologist');
                },function (error){
                    alert('Data is not stored');
                });
        }
        
    };
    $scope.GetStates = function (){      
        
        stateService.query({country_id:$scope.radiologist.country}
            ,function(response){
                $scope.states =response;
            },function (){
            });
    };
};

function RadiologistEditController($scope,sessionService,$state,radiologistService,$stateParams,CONSTANT,countryService,stateService,Notification){
   $scope.page ="Edit";
    $scope.readStatus = false;
        $scope.constant = CONSTANT;
    $scope.countryService =countryService;
    $scope.formValidStatus=false;
    $scope. radiologistGroups =[{radiologistGroupId:1,radiologistGroupName:'Group1'}];
    var init;
    var radiologistId = $stateParams.radiologistId;
    radiologistService.get({radiologistId:radiologistId},function (radiologistData){
           $scope.radiologist = radiologistData;
           init();
       },function (error){
           alert('Somthing went wrong please try again');
    });
    $scope.Submit = function (radiologistStatus){
        if(!radiologistStatus)
        {
            $scope.formValidStatus=true;
            alert('You have missed somthing');
        }
        else{
                $scope.radiologist.$update(function (data){
//                    logger.logSuccess('Successfully edited ');
                    $state.go('manageRadiologist');
                },function (error){
                    alert('Data is not stored');
                });

        }
        
    };
    $scope.GetStates = function (){      
        stateService.query({country_id:$scope.radiologist.country}
            ,function(response){
                $scope.states =response;
            },function (){
            });

    };
    
    init = function (){
        stateService.query({country_id:$scope.radiologist.country}
            ,function(response){
                $scope.states =response;
            },function (){
            });
    };
};

function RadiologistViewController($scope,sessionService,$state,radiologistService,$stateParams,CONSTANT,countryService,stateService,Notification){
        $scope.page ="View";
        $scope.readStatus = true;
        $scope.constant = CONSTANT;
        var init;
        $scope.countryService =countryService;
        var radiologistId = $stateParams.radiologistId;
        $scope. radiologistGroups =[{radiologistGroupId:1,radiologistGroupName:'Group1'}];
        radiologistService.get({radiologistId:radiologistId},function (radiologistData){
           $scope.radiologist = radiologistData;
           init();
        },function (error){
           alert('Somthing went wrong please try again');
        });
        init = function (){
            stateService.query({country_id:$scope.radiologist.country}
            ,function(response){
                $scope.states =response;
            },function (){
            });
        };
        $scope.GetStates = function (){      
        
        stateService.query({country_id:$scope.radiologist.country}
            ,function(response){
                $scope.states =response;
            },function (){
            });
    };
};

function RadiologistGroupController($scope,sessionService,$state,radiologistService,Notification){
    $scope.page ="Add";
    var init;
    $scope.readStatus = false;  
    $scope.Submit = function (radiologistStatus){
        if(!radiologistStatus)
        {
            alert('You have missed somthing');
        }
        else{
                radiologistService.save($scope.radiologistGroup,function (data){
                    $state.go('manageRadiologist');
                },function (error){
                    alert('Data is not stored');
                });

        }
        
    };
};

})();
(function (){
    "use strict";

angular.module('app.payer')
        .controller('PayerController',PayerController)
        .controller('PayerAddController',PayerAddController)
        .controller('PayerEditController',PayerEditController)
        .controller('PayerViewController',PayerViewController);


PayerController.$inject =['$scope','sessionService','$state','payerService','$filter','CONSTANT','countryService','stateService','logger','$log','confirmService'];
PayerAddController.$inject =['$scope','sessionService','$state','payerService','CONSTANT','countryService','stateService','Notification'];
PayerEditController.$inject =['$scope','sessionService','$state','payerService','CONSTANT','countryService','stateService','$stateParams','Notification'];
PayerViewController.$inject =['$scope','sessionService','$state','payerService','CONSTANT','countryService','stateService','$stateParams','Notification'];


function PayerController($scope,sessionService,$state,payerService,$filter,CONSTANT,countryService,stateService,logger,$log,confirmService){
    $log.info("Payer controller initiated");
    var init;
    var isLoggedIn= sessionService.isLoggedIn();
    $scope.constant = CONSTANT;
    $scope.countryService =countryService;
    $scope.currentTab ="listPayer.html";
    $scope.currentTabMain =true;
    $scope.readStatus = false;
    $scope.formValidStatus=false;
    $scope.updateIndex= null;
    $scope.payers=[];
    $scope.payerService = payerService;
    var tempPayer={};
    var tempIndex;
    $scope.showSpinner = true;
    
    // To get list of payer
    payerService.query().$promise.then(function (data){
            $scope.payers = data;
            $scope.showSpinner = false;
            $log.debug("PayerController: Successfully get the list of Payers");
            init();
       
    }).catch(function (error){
        $scope.showSpinner = false;
         throw new Error(error.statusText);
         $log.error("PayerController: " + error.statusText); 
    });
    
    // To get add payer page
    $scope.onClickAdd = function (){
        $log.debug("PayerController: on-click of add payer");
        $scope.page ="Add";
        $scope.currentTabMain =false;
        $scope.currentTab ="addPayerDetails.html";
        $scope.payer ={};
        $scope.readStatus = false;
        $scope.formValidStatus=false;
    };
    
    // To get edit payer page
    $scope.onClickEdit =function (index){
        $log.debug("PayerController: on-click of edit payer");
        $scope.page ="Edit";
        $scope.currentTabMain =false;
        $scope.currentTab ="addPayerDetails.html";
        $scope.payer = $scope.currentPagePayers[index];
        tempPayer = angular.copy($scope.currentPagePayers[index]);
        tempIndex = index;
        $scope.readStatus = false;
        $scope.formValidStatus=false; 
        $scope.updateIndex = index;
        $scope.GetStates();
    };
    
    // To get view payer page
    $scope.onClickView =function (index){
        $log.debug("PayerController: on-click of view payer");
        $scope.page ="View";
        $scope.currentTabMain =false;
        $scope.currentTab ="addPayerDetails.html";
        $scope.payer = $scope.currentPagePayers[index];
        tempPayer = angular.copy($scope.currentPagePayers[index]);
        tempIndex = index;
        $scope.readStatus = true;
        $scope.formValidStatus=false;
        $scope.GetStates();
    };
    
    // To get back to list of payer page
    $scope.onClickList = function (){
        $scope.currentPagePayers[tempIndex] = tempPayer;
        $scope.currentTab ="listPayer.html";
        $scope.currentTabMain =true;
    };

    // To delete payer
    $scope.deletePayer = function (index){
        
        var isConfirmed = confirmService.isConfirmed();
//        alert(isConfirmed);
        var payer = $scope.payers[index];  
        payerService.delete({payerId: payer.payerId}).$promise.then(function(){
            $log.debug("PayerController: successfully deleted payer");
            $scope.payers.splice(index, 1);
            logger.logSuccess('Successfully deleted payer');
            init();
        }).catch(function (error){
             throw new Error(error.statusText);
             $log.error("PayerController: " + error.statusText); 
        });
    };
    
    // To save payer
    $scope.Submit = function (payerStatus){
        if(!payerStatus)
        {
            $scope.formValidStatus=true;
            $log.debug("PayerController: form data is not valid");
            logger.logError("Please fill the required field");
        }
        else{
                $scope.formValidStatus=false;
                if($scope.page === "Add"){
                    payerService.save($scope.payer).$promise.then(function (data){
                    if(data !== null)
                    {
                        $log.debug("PayerController: successfully added new payer");
                        $scope.payers.push(data);
                        logger.logSuccess('Successfully added payer');
                        $scope.currentTab ="listPayer.html";
                        $scope.currentTabMain =true;
                        init();
                    }
                    }).catch(function (error){
                         throw new Error(error.statusText);
                         $log.error("PayerController: " + error.statusText); 
                    });
                }else if($scope.page === "Edit"){
                    payerService.update($scope.payer).$promise.then(function (data){
                        if($scope.updateIndex !== null)
                        {
                            $log.debug("PayerController: successfully updated payer");
                            $scope.payers[$scope.updateIndex] =  $scope.payer;
                            $scope.updateIndex = null;
                        }           
                        logger.logSuccess('Successfully edited ');
                        $scope.currentTab ="listPayer.html";
                        $scope.currentTabMain =true;
                        init();
                    }).catch(function (error){
                         throw new Error(error.statusText);
                         $log.error("PayerController: " + error.statusText); 
                    });
                }               
        }
        
    };
    
    // To get states 
    $scope.GetStates = function (){    
        if($scope.payer.countryId === undefined)
        {
            logger.logError('Please select the country');
        }else{
            stateService.query({country_id:$scope.payer.countryId}).$promise.then(function(response){
                $scope.states =response;
            }).catch(function (error){
                 throw new Error(error.statusText);
                 $log.error("PayerController: " + error.statusText); 
            });
        }
        
    };   
    
    
    //Pagination
    $scope.searchKeywords = '';
    $scope.filteredPayers = [];
    $scope.row = '';
    $scope.select = function(page) {
        var end, start;
        start = (page - 1) * $scope.numPerPage;
        end = start + $scope.numPerPage;
        return $scope.currentPagePayers = $scope.filteredPayers.slice(start, end);
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
        $scope.filteredPayers = $filter('filter')($scope.payers, $scope.searchKeywords);
        return $scope.onFilterChange();
    };
    $scope.order = function(rowName) {
        if ($scope.row === rowName) {
          return;
        }
        $scope.row = rowName;
        $scope.filteredPayers = $filter('orderBy')($scope.payers, rowName);
        return $scope.onOrderChange();
    };
    $scope.numPerPageOpt = [3, 5, 10, 20];
    $scope.numPerPage = $scope.numPerPageOpt[1];
    $scope.currentPage = 1;
    $scope.currentPagePayers = [];
    init = function() {
        $scope.search();
        return $scope.select($scope.currentPage);
    };
    return init();
};

function PayerAddController($scope,sessionService,$state,payerService,CONSTANT,countryService,stateService,Notification){
    $scope.constant = CONSTANT;
    $scope.countryService =countryService;
    $scope.page ="Add";
    $scope.readStatus = false;
    $scope.formValidStatus=false;
    $scope.GetStates = function (){      
        stateService.query({country_id:$scope.payer.country}
            ,function(response){
                $scope.states =response;
            },function (){
            });
    };
    
    $scope.Submit = function (payerStatus){
        if(!payerStatus)
        {
            $scope.formValidStatus=true;
            alert('You have missed somthing');
        }
        else{
                payerService.save($scope.payer,function (data){
//                    logger.logSuccess('Successfully added ');
                    $state.go('managePayer');
                },function (error){
                    alert('Data is not stored');
                });

        }
        
    };
};

function PayerEditController($scope,sessionService,$state,payerService,CONSTANT,countryService,stateService,$stateParams,Notification){
     $scope.constant = CONSTANT;
    $scope.countryService =countryService;
    $scope.page ="Edit";
    $scope.readStatus = false;
    $scope.formValidStatus=false;
    var init;
    var payerId = $stateParams.payerId;
    payerService.get({payerId:payerId},function (payerData){
           $scope.payer = payerData;
           init();
       },function (error){
           alert('Somthing went wrong please try again');
    });
    $scope.GetStates = function (){      
        
        stateService.query({country_id:$scope.payer.country}
            ,function(response){
                $scope.states =response;
            },function (){
            });
    };
    
    $scope.Submit = function (payerStatus){
        if(!payerStatus)
        {
            $scope.formValidStatus=true;
            alert('You have missed somthing');
        }
        else{
                $scope.payer.$update(function (data){
//                    logger.logSuccess('Successfully edited ');
                    $state.go('managePayer');
                },function (error){
                    alert('Data is not stored');
                });
        }
        
    };
    
    init = function (){
        $scope.payer.country=1;
        stateService.query({country_id:$scope.payer.country},function(response){
            $scope.states =response;
        },function (){
        });
    };
};

function PayerViewController($scope,sessionService,$state,payerService,CONSTANT,countryService,stateService,$stateParams,Notification){
        $scope.constant = CONSTANT;
        $scope.countryService =countryService;
        $scope.page ="View";
        $scope.readStatus = true;
        var init;
        var payerId = $stateParams.payerId;
        payerService.get({payerId:payerId},function (payerData){
           $scope.payer = payerData;
           init();
        },function (error){
           alert('Somthing went wrong please try again');
        });
        init = function (){
            $scope.payer.country=1;
            stateService.query({country_id:$scope.payer.country},function(response){
                $scope.states =response;
            },function (){
            });
            
        };
};
})();
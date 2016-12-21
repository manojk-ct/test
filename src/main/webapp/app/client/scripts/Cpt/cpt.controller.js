(function (){
    "use strict";

angular.module('app.cpt')
        .controller('CptChargeController',CptChargeController)
        .controller('CptCodeController',CptCodeController)
        .controller('CptModifierController',CptModifierController)
        .controller('CptCodeModalInstanceController',CptCodeModalInstanceController);


CptChargeController.$inject =['$scope','cptChargesService','stateService','Notification','$log','$filter','logger'];
CptCodeController.$inject =['$scope','cptCodeService','$log','$filter','$modal','logger','cptTimeDataService'];
CptModifierController.$inject =['$scope','cptModifierService','$log','$filter','logger'];
CptCodeModalInstanceController.$inject =['$scope','$modalInstance','$log','cptTimeDataService','$filter'];


function CptChargeController($scope,cptChargesService,stateService,Notification,$log,$filter,logger){
    $log.info("Cpt Charge controller initiated");
    $scope.currentTabMain = true;
    var init;
    $scope.cptCharges =[];
    var tempCptCharge={};
    var tempIndex;
    $scope.showSpinner = true;
    // To get all cpt charges
    cptChargesService.query().$promise.then(function (cptChargeData){
        $log.debug("CptChargeController: Successfully get the list of CptCharges");
        $scope.showSpinner = false;
        $scope.cptCharges = cptChargeData;
        init();
    }).catch(function (error){
        $scope.showSpinner = false;
         throw new Error(error.statusText);
         $log.error("CptChargeController: " + error.statusText); 
    });
    
    // To get add cpt charge
    $scope.onClickAdd = function (){
        $log.debug("CptChargeController: on-click of add bodypart");
        $scope.page ="Add";
        $scope.currentTabMain =false;
        $scope.cptCharge ={};
        $scope.readStatus = false;
        $scope.formValidStatus=false;
    };
    
    // To get edit cpt charge
    $scope.onClickEdit =function (index){
        $log.debug("CptChargeController: on-click of edit bodypart");
        $scope.page ="Edit";
        $scope.currentTabMain =false;
        $scope.cptCharge = $scope.currentPageCptCharges[index];
        tempCptCharge = angular.copy($scope.currentPageCptCharges[index]);
        tempIndex = index;
        $scope.readStatus = false;
        $scope.formValidStatus=false; 
        $scope.updateIndex = index;
    };
    
    // To get view cpt charge
    $scope.onClickView =function (index){
        $log.debug("CptChargeController: on-click of view bodypart");
        $scope.page ="View";
        $scope.currentTabMain =false;
        $scope.cptCharge = $scope.currentPageCptCharges[index];
        tempCptCharge = angular.copy($scope.currentPageCptCharges[index]);
        tempIndex = index;
        $scope.readStatus = true;
        $scope.formValidStatus=false;
    };
    
    // To get back to list  cpt charge 
    $scope.onClickList = function (){
        $scope.currentPageCptCharges[tempIndex] = tempCptCharge;
        $scope.currentTabMain =true;
    }; 
     
    // Get states on selection of country 
    $scope.GetStates = function (){      
        stateService.query({countryId_id:$scope.cptCharge.countryId}).$promise.then(function(response){
            $log.debug("CptChargeController: Successfully get the list of states");
                $scope.states =response;
            }).catch(function (error){
                 throw new Error(error.statusText);
                 $log.error("CptChargeController: " + error.statusText); 
            });
    };
     
    //Delete Technologist
    $scope.deleteCPTCharges = function (index){
        var cptCharge = $scope.cptCharges[index];
        cptChargesService.delete({cptChargeId: cptCharge.cptChargeId}).$promise.then(function (){
                $log.debug("CptChargeController: successfully deleted CptCharge");
                $scope.cptCharges.splice(index, 1);
                logger.logSuccess('Successfully deleted CptCharge');
                init();
        }).catch(function (error){
             throw new Error(error.statusText);
             $log.error("CptChargeController: " + error.statusText); 
        });
    };
    
    // To save  cpt charge
    $scope.Submit = function (cptChargeStatus){
        if(!cptChargeStatus)
        {
            $scope.formValidStatus =true;
            $log.debug("CptChargeController: form data is not valid");
            logger.logError("Please fill the required field");
        }
        else{
                $scope.formValidStatus=false;
                if($scope.page === "Add"){
                    cptChargesService.save($scope.cptCharge).$promise.then(function (data){
                        if(data !== null)
                        {
                            $log.debug("CptChargeController: successfully added new CptCharge");
                            $scope.cptCharges.push(data);
                            logger.logSuccess('Successfully added new CptCharge');
                            $scope.currentTabMain =true;
                            init();
                        }
                    }).catch(function (error){
                         throw new Error(error.statusText);
                         $log.error("CptChargeController: " + error.statusText); 
                    });
                }else if($scope.page === "Edit"){
                    cptChargesService.update($scope.cptCharge).$promise.then(function (){
                        if($scope.updateIndex !== null)
                        {
                            $log.debug("CptChargeController: successfully updated CptCharge");
                            $scope.cptCharges[$scope.updateIndex] =  $scope.cptCharge;
                            $scope.updateIndex = null;
                        }  
                        logger.logSuccess('Successfully updated CptCharge ');
                        $scope.currentTabMain =true;
                        init();
                     }).catch(function (error){
                             throw new Error(error.statusText);
                             $log.error("CptChargeController: " + error.statusText); 
                     });
                }
        }
    };
    
    //pagination
    $scope.searchKeywords = '';
    $scope.filteredCptCharges = [];
    $scope.row = '';
    $scope.select = function(page) {
      var end, start;
      start = (page - 1) * $scope.numPerPage;
      end = start + $scope.numPerPage;
      
      return $scope.currentPageCptCharges = $scope.filteredCptCharges.slice(start, end);
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
      $scope.filteredCptCharges = $filter('filter')($scope.cptCharges, $scope.searchKeywords);
      return $scope.onFilterChange();
    };
    $scope.order = function(rowName) {
      if ($scope.row === rowName) {
        return;
      }
      $scope.row = rowName;
      $scope.filteredCptCharges = $filter('orderBy')($scope.cptCharges, rowName);
      return $scope.onOrderChange();
    };
    $scope.numPerPageOpt = [3, 5, 10, 20];
    $scope.numPerPage = $scope.numPerPageOpt[1];
    $scope.currentPage = 1;
    $scope.currentPageCptCharges = [];
    init = function() {
      $scope.search();
      return $scope.select($scope.currentPage);
    };
    return init();
};
function CptCodeController($scope,cptCodeService,$log,$filter,$modal,logger,cptTimeDataService){
    $log.info("CptCode controller initiated");
    $scope.currentTabMain = true;
    var init;
    $scope.cptCodes =[];
    var tempCptCode={};
    var tempIndex;
    $scope.showSpinner = true;
    cptCodeService.query().$promise.then(function (cptCodeData){
        $scope.cptCodes = cptCodeData;
        $scope.showSpinner = false;
        $log.debug("CptCodeController: Successfully get the list of CptCode");
        init();
    }).catch(function (error){
        $scope.showSpinner = false;
        throw new Error(error.statusText);
         $log.error("CptCodeController: " + error.statusText); 
    });
    
    
    $scope.onClickAdd = function (){
        $log.debug("CptCodeController: on-click of add CptCode");
        $scope.page ="Add";
        $scope.currentTabMain = false;
        $scope.cptCode ={};
        $scope.cptCode.cptTimeObject =[];
        $scope.readStatus = false;
        $scope.formValidStatus=false;
    };
    
    $scope.onClickEdit =function (index){
        $log.debug("CptCodeController: on-click of edit CptCode");
        $scope.page ="Edit";
        $scope.currentTabMain =false;
        $scope.cptCode = $scope.currentPageCptCodes[index];
        tempCptCode = angular.copy($scope.currentPageCptCodes[index]);
        tempIndex = index;
        $scope.readStatus = false;
        $scope.formValidStatus=false; 
        $scope.updateIndex = index;
    };
    
    $scope.onClickView =function (index){
        $log.debug("CptCodeController: on-click of view CptCode");
        $scope.page ="View";
       // $scope.currentTabMain ="addCPTCodesDetails.html";
        $scope.currentTabMain =false;
        $scope.cptCode = $scope.currentPageCptCodes[index];
        tempCptCode = angular.copy($scope.currentPageCptCodes[index]);
        tempIndex = index;
        $scope.readStatus = true;
        $scope.formValidStatus=false;
    };
    
    $scope.onClickList = function (){
        $scope.currentPageCptCodes[tempIndex] = tempCptCode;
        $scope.currentTabMain =true;
    }; 
     
     
    //Delete Technologist
    $scope.deleteCptCode = function (index){
        var cptCode = $scope.cptCodes[index];
        cptCodeService.delete({cptId: cptCode.cptId}).$promise.then(function (){
                $log.debug("CptCodeController: successfully deleted CptCode");
                $scope.cptCodes.splice(index, 1);
                logger.logSuccess('Successfully deleted CptCode');
                init();
        }).catch(function (error){
            throw new Error(error.statusText);
         $log.error("CptCodeController: " + error.statusText); 
        });
    };
    
    $scope.Submit = function (cptCodeStatus){
        if(!cptCodeStatus)
        {
            $scope.formValidStatus =true;
            $log.debug("CptCodeController: form data is not valid");
            alert('You have missed somthing');
        }
        else{
                $scope.formValidStatus=false;
                if($scope.page === "Add"){
                    alert($scope.cptCode.cptTime );
                    $scope.cptCode.cptTime = $filter('date')($scope.cptCode.cptTime,'HH:mm:ss');
                    alert($scope.cptCode.cptTime);
                    cptCodeService.save($scope.cptCode).$promise.then(function (data){
                        if(data !== null)
                        {
                            $log.debug("CptCodeController: successfully added new CptCode");
                            $scope.cptCodes.push(data);
                            logger.logSuccess('Successfully added new CptCode');
                            $scope.currentTabMain =true;
                            init();
                        }
                        
                    }).catch(function (error){
                        throw new Error(error.statusText);
                        $log.error("CptCodeController: " + error.statusText); 
                    });
                }else if($scope.page === "Edit"){
                    cptCodeService.update($scope.cptCode).$promise.then(function (){
                        if($scope.updateIndex !== null)
                        {
                            $log.debug("CptCodeController: successfully updated CptCode");
                            $scope.cptCodes[$scope.updateIndex] =  $scope.cptCode;
                            $scope.updateIndex = null;
                        }  
                        logger.logSuccess('Successfully updated CptCode ');
                        $scope.currentTabMain =true;
                        init();
                     }).catch(function (error){
                            throw new Error(error.statusText);
                            $log.error("CptCodeController: " + error.statusText); 
                     });
                }
        }
        
    };
    
    // TO open modal to add  cptTime
    $scope.open = function (){
            $scope.cptTime=null;
            cptTimeDataService.SetCptTime($scope.cptTime);
            var modalInstance;
            modalInstance = $modal.open({
                templateUrl: "cptinformation.html",
                controller: 'CptCodeModalInstanceController'
            });

            modalInstance.result.then((function(cptTime) {
//                cptTime.cptTime = cptTime.cptTime.getTime();
                $scope.cptCode.cptTimeObject.push(cptTime);                
            }), function() {
                $log.info("CptCodeController : Modal dismissed");
            });
    };
    
    // To edit  cptTime
    $scope.editCptTime = function (index){            
            $scope.cptTime = $scope.cptCode.cptTimeObject[index];      
            cptTimeDataService.SetCptTime($scope.cptTime);
            var modalInstance;
            modalInstance = $modal.open({
                templateUrl: "cptinformation.html",
                controller: 'CptCodeModalInstanceController'
            });
            
            modalInstance.result.then((function(cptTime) {
                $scope.cptCode.cptTimeObject[index] = cptTime;
                $scope.cptTime={};
            }), function() {
                $log.info("CptCodeController : Modal dismissed");
            });
    };
    
    // To delete cptTime
    $scope.deleteCptTime = function (index){      
        $scope.cptCode.cptTimeObject.splice(index, 1);    
        $log.info("CptCodeController : Cpt Time deleted successfully");
    };
   
    
    //pagination
    $scope.searchKeywords = '';
    $scope.filteredCptCodes = [];
    $scope.row = '';
    $scope.select = function(page) {
      var end, start;
      start = (page - 1) * $scope.numPerPage;
      end = start + $scope.numPerPage;
      return $scope.currentPageCptCodes = $scope.filteredCptCodes.slice(start, end);
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
      $scope.filteredCptCodes = $filter('filter')($scope.cptCodes, $scope.searchKeywords);
      return $scope.onFilterChange();
    };
    $scope.order = function(rowName) {
      if ($scope.row === rowName) {
        return;
      }
      $scope.row = rowName;
      $scope.filteredCptCodes = $filter('orderBy')($scope.cptCodes, rowName);
      return $scope.onOrderChange();
    };
    $scope.numPerPageOpt = [3, 5, 10, 20];
    $scope.numPerPage = $scope.numPerPageOpt[1];
    $scope.currentPage = 1;
    $scope.currentPageCptCodes = [];
    init = function() {
      $scope.search();
      return $scope.select($scope.currentPage);
    };
    return init();
};
function CptModifierController($scope,cptModifierService,$log,$filter,logger){
    $log.info("CptModifier controller initiated");
    //$scope.currentTabMain ="listCPTModifier.html";
      $scope.currentTabMain =true;
    var init;
    $scope.cptModifiers =[];
    var tempCptModifier={};
    var tempIndex;
    $scope.showSpinner = true;
    cptModifierService.query().$promise.then(function (cptModifierData){
        $scope.cptModifiers = cptModifierData;
        $scope.showSpinner = false;
        $log.debug("CptModifierController: Successfully get the list of CptModifier");
        init();
    }).catch(function (error){
        $scope.showSpinner = false;
        throw new Error(error.statusText);
         $log.error("CptModifierController: " + error.statusText); 
    });
    
    
    $scope.onClickAdd = function (){
        $log.debug("CptModifierController: on-click of add CptModifier");
        $scope.page ="Add";
       // $scope.currentTabMain ="addCPTModifierDetails.html";
         $scope.currentTabMain =false;
        $scope.cptModifier ={};
        $scope.readStatus = false;
        $scope.formValidStatus=false;
    };
    
    $scope.onClickEdit =function (index){
        $log.debug("CptModifierController: on-click of edit CptModifier");
        $scope.page ="Edit";
        $scope.currentTabMain =false;
        $scope.cptModifier = $scope.currentPageCptModifiers[index];
        tempCptModifier = angular.copy($scope.currentPageCptModifiers[index]);
        tempIndex = index;
        $scope.readStatus = false;
        $scope.formValidStatus=false; 
        $scope.updateIndex = index;
    };
    
    $scope.onClickView =function (index){
        $log.debug("CptModifierController: on-click of view CptModifier");
        $scope.page ="View";
        $scope.currentTabMain =false;
        $scope.cptModifier = $scope.currentPageCptModifiers[index];
        tempCptModifier = angular.copy($scope.currentPageCptModifiers[index]);
        tempIndex = index;
        $scope.readStatus = true;
        $scope.formValidStatus=false;
    };
    
    $scope.onClickList = function (){
        $scope.currentPageCptModifiers[tempIndex] = tempCptModifier;
        $scope.currentTabMain =true;
    }; 
     
    //Delete Technologist
    $scope.deleteCptModifier = function (index){
        var cptModifier = $scope.cptModifiers[index];
        cptModifierService.delete({cptModifierId: cptModifier.cptModifierId}).$promise.then(function (){
                $log.debug("CptModifierController: successfully deleted CptModifier");
                $scope.cptModifiers.splice(index, 1);
                logger.logSuccess('Successfully deleted CptModifier');
                init();
        }).catch(function (error){
            throw new Error(error.statusText);
         $log.error("CptModifierController: " + error.statusText); 
        });
    };
    
    $scope.Submit = function (cptModifierStatus){
        if(!cptModifierStatus)
        {
            $scope.formValidStatus =true;
            $log.debug("CptModifierController: form data is not valid");
            alert('You have missed somthing');
        }
        else{
                $scope.formValidStatus=false;
                if($scope.page === "Add"){

                    cptModifierService.save($scope.cptModifier).$promise.then(function (data){
                        if(data !== null)
                        {
                            $log.debug("CptModifierController: successfully added new CptModifier");
                            $scope.cptModifiers.push(data);
                            logger.logSuccess('Successfully added new CptModifier');
                            $scope.currentTabMain =true;
                            init();
                        }
                    }).catch(function (error){
                        throw new Error(error.statusText);
                        $log.error("CptModifierController: " + error.statusText); 
                    });
                }else if($scope.page === "Edit"){
                    cptModifierService.update($scope.cptModifier).$promise.then(function (){
                        if($scope.updateIndex !== null)
                        {
                            $log.debug("CptModifierController: successfully updated CptModifier");
                            $scope.cptModifiers[$scope.updateIndex] =  $scope.cptModifier;
                            $scope.updateIndex = null;
                        }  
                        logger.logSuccess('Successfully updated CptModifier ');
                        $scope.currentTabMain =true;
                        init();
                     }).catch(function (error){
                            throw new Error(error.statusText);
                            $log.error("CptModifierController: " + error.statusText); 
                     });
                }
        }
        
    };
    
    //pagination
    $scope.searchKeywords = '';
    $scope.filteredCptModifiers = [];
    $scope.row = '';
    $scope.select = function(page) {
      var end, start;
      start = (page - 1) * $scope.numPerPage;
      end = start + $scope.numPerPage;
      
      return $scope.currentPageCptModifiers = $scope.filteredCptModifiers.slice(start, end);
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
      $scope.filteredCptModifiers = $filter('filter')($scope.cptModifiers, $scope.searchKeywords);
      return $scope.onFilterChange();
    };
    $scope.order = function(rowName) {
      if ($scope.row === rowName) {
        return;
      }
      $scope.row = rowName;
      $scope.filteredCptModifiers = $filter('orderBy')($scope.cptModifiers, rowName);
      return $scope.onOrderChange();
    };
    $scope.numPerPageOpt = [3, 5, 10, 20];
    $scope.numPerPage = $scope.numPerPageOpt[1];
    $scope.currentPage = 1;
    $scope.currentPageCptModifiers = [];
    init = function() {
      $scope.search();
      return $scope.select($scope.currentPage);
    };
    return init();
};

function CptCodeModalInstanceController($scope,$modalInstance,$log,cptTimeDataService,$filter){
        $scope.cptTime =cptTimeDataService.GetCptTime();
        $scope.ok = function() {
            $scope.cptTime.cptTime = $filter('date')($scope.cptTime.cptTime,'HH:mm:ss');
            $modalInstance.close($scope.cptTime);
        };
        $scope.cancel = function() {
            $modalInstance.dismiss("cancel");
        };
};

})();
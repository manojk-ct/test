(function (){
    "use strict";

angular.module('app.icd')
        .controller('IcdController',IcdController);

IcdController.$inject =['$scope','icdService','$log','$filter','logger'];

function IcdController($scope,icdService,$log,$filter,logger){
    $log.info("ICD controller initiated");
    //$scope.currentTabMain ="listICDCode.html";
    $scope.currentTabMain = true;
    var init;
    $scope.icdCodes =[];
    $scope.showSpinner = false;
    // To get list of icd code
    icdService.query().$promise.then(function (icdCodeData){
        $log.debug("IcdController: Successfully get the list of ICD's");
        $scope.showSpinner = false;
        $scope.icdCodes = icdCodeData;
        init();
    }).catch(function (error){
        $scope.showSpinner = false;
         throw new Error(error.statusText);
         $log.error("IcdController: " + error.statusText);
    });
    
    // To get add icd page
    $scope.onClickAdd = function (){
        $log.debug("IcdController: on-click of add ICd");
        $scope.page ="Add";
        //$scope.currentTabMain ="addICDCodeDetails.html";
         $scope.currentTabMain =false;
        $scope.icdCode ={};
        $scope.readStatus = false;
        $scope.formValidStatus=false;
    };
    
    // To get edit icd page
    $scope.onClickEdit =function (index){
        $log.debug("IcdController: on-click of edit ICd");
        $scope.page ="Edit";
        //$scope.currentTabMain ="addICDCodeDetails.html";
         $scope.currentTabMain =false;
        $scope.icdCode = $scope.currentPageIcdCodes[index];
        $scope.readStatus = false;
        $scope.formValidStatus=false; 
        $scope.updateIndex = index;
    };
    
    // To get view icd page
    $scope.onClickView =function (index){
        $log.debug("IcdController: on-click of view ICd");
        $scope.page ="View";
        //$scope.currentTabMain ="addICDCodeDetails.html";
         $scope.currentTabMain =false;
        $scope.icdCode = $scope.currentPageIcdCodes[index];
        $scope.readStatus = true;
        $scope.formValidStatus=false;
    };
    
    // To get back to list of icd page
    $scope.onClickList = function (){
        //$scope.currentTabMain ="listICDCode.html";
        $scope.currentTabMain = true;
    }; 
    
     
    //Delete Technologist
    $scope.deleteIcdCode = function (index){
        var icdCode = $scope.icdCodes[index];
        icdService.delete({icdCodeId: icdCode.icdCodeId}).$promise.then(function (){
                $log.debug("IcdController: successfully deleted ICD");
                $scope.icdCodes.splice(index, 1);
                logger.logSuccess('Successfully deleted ICD');
                init();
        }).catch(function (error){
             throw new Error(error.statusText);
             $log.error("IcdController: " + error.statusText);
            
        });
    };
    
    // To save icd 
    $scope.Submit = function (icdCodeStatus){
        if(!icdCodeStatus)
        {
            $scope.formValidStatus =true;
            $log.debug("IcdController: form data is not valid");
            logger.logError("Please fill the required field");
        }
        else{
                $scope.formValidStatus=false;
                if($scope.page === "Add"){

                    icdService.save($scope.icdCode).$promise.then(function (data){
                        $log.debug("IcdController: successfully added new ICd");
                        $scope.icdCodes.push($scope.icdCode);
                        logger.logSuccess('Successfully added ICD');
                        //$scope.currentTabMain ="listICDCode.html";
                        $scope.currentTabMain = true;
                        init();
                    }).catch(function (error){
                         throw new Error(error.statusText);
                         $log.error("IcdController: " + error.statusText);
                    });
                }else if($scope.page === "Edit"){
                    icdService.update($scope.icdCode).$promise.then(function (){
                        if($scope.updateIndex !== null)
                        {
                            $log.debug("IcdController: successfully updated ICD");
                            $scope.icdCodes[$scope.updateIndex] =  $scope.icdCode;
                            $scope.updateIndex = null;
                        }  
                        logger.logSuccess('Successfully updated ICD ');
                        //$scope.currentTabMain ="listICDCode.html";
                        $scope.currentTabMain = true;
                        init();
                     }).catch(function (error){
                             throw new Error(error.statusText);
                             $log.error("IcdController: " + error.statusText);
                     });
                }
              
        }
        
    };
    
    //pagination
    $scope.searchKeywords = '';
    $scope.filteredIcdCodes = [];
    $scope.row = '';
    $scope.select = function(page) {
      var end, start;
      start = (page - 1) * $scope.numPerPage;
      end = start + $scope.numPerPage;
      
      return $scope.currentPageIcdCodes = $scope.filteredIcdCodes.slice(start, end);
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
      $scope.filteredIcdCodes = $filter('filter')($scope.icdCodes, $scope.searchKeywords);
      return $scope.onFilterChange();
    };
    $scope.order = function(rowName) {
      if ($scope.row === rowName) {
        return;
      }
      $scope.row = rowName;
      $scope.filteredIcdCodes = $filter('orderBy')($scope.icdCodes, rowName);
      return $scope.onOrderChange();
    };
    $scope.numPerPageOpt = [3, 5, 10, 20];
    $scope.numPerPage = $scope.numPerPageOpt[1];
    $scope.currentPage = 1;
    $scope.currentPageIcdCodes = [];
    init = function() {
      $scope.search();
      return $scope.select($scope.currentPage);
    };
    return init();
};

})();
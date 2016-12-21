(function (){
    "use strict";
angular.module('app.van')
        .controller('VanController',VanController);

VanController.$inject =['$scope','vanService','$state','$filter','sessionService','Notification','logger','$log'];


function VanController($scope,vanService,$state,$filter,sessionService,Notification,logger,$log){
    $scope.vans=[{vanId : 0,vanNumber:123,vanCode:123,fromTime:2,toTime:6,currentLocation:"pune",status:"A"},
                    {vanId : 1,vanNumber:1234,vanCode:1234,fromTime:3,toTime:7,currentLocation:"pune",status:"A"},
                    {vanId : 2,vanNumber:1235,vanCode:1235,fromTime:4,toTime:8,currentLocation:"pune",status:"A"}];
    $log.info("VanController initiated");                    
    $scope.currentTabMain = true;
    var tempVan={};
    var tempIndex;
    var init;
    $scope.showSpinner = true;
    
    vanService.query().$promise.then(function (tenantData){
        $scope.vans = tenantData;
        $scope.showSpinner = false;
        $log.debug("VanController: Successfully get the list of van");
        init();
    }).catch(function (error){
        $scope.showSpinner = false;
        throw new Error(error.statusText);
        $log.error("VanController: " + error.statusText); 
    });
    
    
    $scope.onClickAdd = function (){
        $log.debug("VanController: on-click of add van");
        $scope.page ="Add";
        $scope.currentTabMain =false;
        $scope.van ={};
        $scope.readStatus = false;
        $scope.formValidStatus=false;
    };
    
    $scope.onClickEdit =function (index){
        $log.debug("VanController: on-click of edit van");
        $scope.page ="Edit";
        $scope.currentTabMain = false;
        $scope.van = $scope.currentPageVans[index];
        tempVan = angular.copy($scope.currentPageVans[index]);
        tempIndex = index;
        $scope.readStatus = false;
        $scope.formValidStatus=false; 
        $scope.updateIndex = index;
    };
    
    $scope.onClickView =function (index){
        $log.debug("VanController: on-click of view van");
        $scope.page ="View";
       $scope.currentTabMain =false;
        $scope.van = $scope.currentPageVans[index];
        tempVan = angular.copy($scope.currentPageVans[index]);
        tempIndex = index;
        $scope.readStatus = true;
        $scope.formValidStatus=false;
    };
    
    $scope.onClickList = function (){
        $scope.currentPageVans[tempIndex] = tempVan;
        $scope.currentTabMain =true;
    }; 
    
     
    //Delete Technologist
    $scope.deleteVan = function (index){
        var van = $scope.vans[index];
        vanService.delete({vanId: van.vanId}).$promise.then(function (){
            $log.debug("VanController: successfully deleted van");
            $scope.vans.splice(index, 1);
            Notification.success('Successfully deleted ');
            init();
        }).catch(function (error){
            throw new Error(error.statusText);
            $log.error("VanController: " + error.statusText); 
        });
    };
    
    $scope.Submit = function (vanStatus){
        if(!vanStatus)
        {
            $scope.formValidStatus =true;
            $log.debug("VanController: form data is not valid");
            logger.logError("Please fill the required field");
        }
        else{
                $scope.formValidStatus=false;
                if($scope.page === "Add"){
                    vanService.save($scope.van).$promise.then(function (data){
                        if(data !== null)
                        {
                            $log.debug("VanController: successfully added new van");
                            $scope.vans.push($scope.van);
                            Notification.success('Successfully added ');
                            $scope.currentTabMain =true;
                            init();
                        }
                        
                    }).catch(function (error){
                       throw new Error(error.statusText);
                        $log.error("VanController: " + error.statusText); 
                    });
                }else if($scope.page === "Edit"){
                    vanService.update($scope.van).$promise.then(function (){
                        if($scope.updateIndex !== null)
                        {
                            $log.debug("VanController: successfully updated van");
                            $scope.vans[$scope.updateIndex] =  $scope.van;
                            $scope.updateIndex = null;
                        }  
                        Notification.success('Successfully edited ');
                        //$scope.currentTabMain ="listVan.html";
                         $scope.currentTabMain =true;
                        init();
                     }).catch(function (error){
                            throw new Error(error.statusText);
                            $log.error("VanController: " + error.statusText); 
                     });
                }
              
        }
    };
    
    //Time-Picker
    $scope.openFromTime = function($event) {
      $event.preventDefault();
      $event.stopPropagation();
      return $scope.openFromTimeStatus = true;
    };
    
    $scope.timeOptions = {
        readonlyInput: false,
        showMeridian: false
    };
    
    //pagination
    $scope.searchKeywords = '';
    $scope.filteredVans = [];
    $scope.row = '';
    $scope.select = function(page) {
      var end, start;
      start = (page - 1) * $scope.numPerPage;
      end = start + $scope.numPerPage;
      
      return $scope.currentPageVans = $scope.filteredVans.slice(start, end);
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
      $scope.filteredVans = $filter('filter')($scope.vans, $scope.searchKeywords);
      return $scope.onFilterChange();
    };
    $scope.order = function(rowName) {
      if ($scope.row === rowName) {
        return;
      }
      $scope.row = rowName;
      $scope.filteredVans = $filter('orderBy')($scope.vans, rowName);
      return $scope.onOrderChange();
    };
    $scope.numPerPageOpt = [3, 5, 10, 20];
    $scope.numPerPage = $scope.numPerPageOpt[1];
    $scope.currentPage = 1;
    $scope.currentPageVans = [];
    init = function() {
      $scope.search();
      return $scope.select($scope.currentPage);
    };
    return init();
    
};
})();
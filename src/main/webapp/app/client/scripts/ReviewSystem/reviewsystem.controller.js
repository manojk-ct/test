(function (){
    "use strict";
angular.module('app.reviewsystem')
        .controller('ReviewSystemController',ReviewSystemController)
        .controller('GroupModalInstanceController',GroupModalInstanceController)
        .controller('QuestionModalInstanceController',QuestionModalInstanceController);

ReviewSystemController.$inject =['reviewsystemService','$filter','sessionService','$state','$scope','$log','CONSTANT','$modal','logger','groupService'];
GroupModalInstanceController.$inject =['$scope', '$modalInstance','groupDataService','$log'];
QuestionModalInstanceController.$inject =['$scope', '$modalInstance','questionDataService','$log'];

function ReviewSystemController(reviewsystemService,$filter,sessionService,$state,$scope,$log,CONSTANT,$modal,logger,groupService){
    $scope.showSpinner = false;
    
    // To get list of facilities
    groupService.query(function (data){
        $log.debug("ReviewSystemController : Successfully get the list of groups");
        $scope.showSpinner = false;
        $scope.groups = data;
        init();
    },function (error){
        throw new Error(error.statusText);
        $log.error("ReviewSystemController: " + error.statusText);
    });
    
    
    $scope.openGroup = function (){
        var modalInstance;
        modalInstance = $modal.open({
            templateUrl: "addGroup.html",
            controller: 'GroupModalInstanceController'
        });
    };
          
    $scope.openQuestion = function (){

        var modalInstance;
        modalInstance = $modal.open({
            templateUrl: "addQuestion.html",
            controller: 'QuestionModalInstanceController'
       });
    };
};

function GroupModalInstanceController($scope,$modalInstance,groupDataService,$log){
        $log.debug("GroupModalInstanceController : Initiated");
//        $scope.data =dataService.GetData();
        $scope.ok = function() {
            $modalInstance.close($scope.data);
        };
        $scope.cancel = function() {
            $modalInstance.dismiss("cancel");
        };
};

function QuestionModalInstanceController($scope,$modalInstance,questionDataService,$log){
        $log.debug("QuestionModalInstanceController : Initiated");
//        $scope.data =dataService.GetData();
        $scope.ok = function() {
            $modalInstance.close($scope.data);
        };
        $scope.cancel = function() {
            $modalInstance.dismiss("cancel");
        };
};

})();
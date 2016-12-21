(function (){
    "use strict";

angular.module('app.requisition')
        .controller('RequisitiontAddController',RequisitiontAddController);

RequisitiontAddController.$inject =['$scope','sessionService','$state','$modal'];


function RequisitiontAddController($scope,sessionService,$state,$modal){
    $scope.showSpinner = false;
//    $scope.tabs = [{
//        title :'Patient Information',
//        url:'patientInformation.html'
//    },{
//        title :'Contact Details',
//        url:'contactDetails.html'
//    },{
//        title :'Insurance Details',
//        url:'insuranceDetails.html'
//      
//    },{
//        title :'Notes',
//        url:'notes.html'
//    }];
//    $scope.currentTab = 'patientInformation.html';
//    $scope.onClickTab = function (tab)
//    {
//    $scope.currentTab = tab.url;
//    };
//    $scope.isActiveTab = function(tabUrl) {
//        return tabUrl === $scope.currentTab;
//    };
//    
//            $scope.insur = function (){
//            var modalInstance;
//            modalInstance = $modal.open({
//            templateUrl: "insur_tabs.html",
//            controller:'InsuranceModalInstanceController',
//            windowClass: 'app-modal-window'
//               
//
//            });
//          };
    };

})();
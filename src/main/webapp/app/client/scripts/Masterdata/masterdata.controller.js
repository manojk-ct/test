(function (){
    "use strict";
angular.module('app.masterdata')
        .controller('MasterdataController',MasterdataController)
        .controller('MasterdataModalInstanceController',MasterdataModalInstanceController);

MasterdataController.$inject =['masterdataService','$filter','sessionService','$state','$scope','$log','CONSTANT','$modal','logger'];
MasterdataModalInstanceController.$inject =['$scope', '$modalInstance','dataService','$log'];
 

function MasterdataController(masterdataService,$filter,sessionService,$state,$scope,$log,CONSTANT,$modal,logger){
    $scope.info_master = [
        {'id': 'placeOfService.html','name': 'Place of Service'},
        {'id': 'paymentType.html','name': 'Payment Type'},
        {'id': 'taxanomyCode.html','name': 'Taxanomy Code'},
        {'id': 'orderStatus.html','name': 'Ordering Status'},
        {'id': 'insuranceType.html','name': 'Insurance Type'},
        {'id': 'medicaidType.html','name': 'Medicaid Type'},
        {'id': 'medicareType.html','name': 'Medicare Type'},
        {'id': 'clearingHouse.html','name': 'Clearing House'},
        {'id': 'claimType.html','name': 'Claim Type'},
        {'id': 'identification.html','name': 'Identification'},
        {'id': 'defaultRate.html','name': 'Default Rate'}
    ];
    
    $scope.open = function (){
            var modalInstance; 
            console.log($scope.masterData);
            modalInstance = $modal.open({
                templateUrl: "add" +$scope.masterData,
                controller: 'MasterdataModalInstanceController'
            });

            modalInstance.result.then((function(data) {
                
            }), function() {
                
            });
    };
};

function MasterdataModalInstanceController($scope,$modalInstance,dataService,$log){
        $log.debug("FacilityModalInstanceController : Initiated");
        $scope.data =dataService.GetData();
        $scope.ok = function() {
            $modalInstance.close($scope.data);
        };
        $scope.cancel = function() {
            $modalInstance.dismiss("cancel");
        };
};

})();
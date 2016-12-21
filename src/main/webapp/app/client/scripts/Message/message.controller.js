(function (){
    "use strict";
angular.module('app.message')
        .controller('MessageController',MessageController)
        .controller('MessageModalInstanceController',MessageModalInstanceController);

MessageController.$inject =['messageService','$filter','sessionService','$state','$scope','$log','CONSTANT','messageDataService','$modal','logger'];
MessageModalInstanceController.$inject =['$scope', '$modalInstance','messageDataService','$log'];
 

function MessageController(messageService,$filter,sessionService,$state,$scope,$log,CONSTANT,messageDataService,$modal,logger){
   
   $scope.messages = [{subject:"Test",message:"Working Progress",to:'test@gmail.com',date:'03/22/2016'},
                        {subject:"Test",message:"Working Progress",to:'test@gmail.com',date:'03/22/2016'},
                        {subject:"Test",message:"Working Progress",to:'test@gmail.com',date:'03/22/2016'},
                        {subject:"Test",message:"Working Progress",to:'test@gmail.com',date:'03/22/2016'},
                        {subject:"Test",message:"Working Progress",to:'test@gmail.com',date:'03/22/2016'}];
    $scope.showSpinner = false;
    $scope.addMessage = function (){
         $log.debug("FacilityController : Contact modal open");
             $scope.message=null;
             messageDataService.SetMessage($scope.message);
             var modalInstance;
             modalInstance = $modal.open({
                 templateUrl: "addMessage.html",
                 controller: 'MessageModalInstanceController'
             });

             modalInstance.result.then((function(message) {
                 $log.info("FacilityController : Contact added");
                 $scope.messages.push(message);                
             }), function() {
                 $log.info("FacilityController : Modal dismissed");
             });
    };
    
    $scope.editMessage = function (index){
        $scope.message = $scope.messages[index];
        messageDataService.SetMessage($scope.message);
        var modalInstance;
            modalInstance = $modal.open({
                templateUrl: "addMessage.html",
                controller: 'MessageModalInstanceController'
            });

            modalInstance.result.then((function(message) {
                $log.info("FacilityController : Contact added");
                $scope.messages.push(message);                
            }), function() {
                $log.info("FacilityController : Modal dismissed");
            });
    };
};

function MessageModalInstanceController($scope,$modalInstance,messageDataService,$log){
        $log.debug("FacilityModalInstanceController : Initiated");
        $scope.message = messageDataService.GetMessage();
        $scope.ok = function() {
            $modalInstance.close($scope.message);
        };
        $scope.cancel = function() {
            $modalInstance.dismiss("cancel");
        };
        $scope.message = function (){
            $scope.message = {};  
        };
};
})();
(function (){
    "use strict";
angular.module('app.profile')
        .controller('ProfileController',ProfileController);

ProfileController.$inject =['profileService','$filter','sessionService','$state','$scope','$log','CONSTANT','$modal','logger'];

 

function ProfileController(profileService,$filter,sessionService,$state,$scope,$log,CONSTANT,$modal,logger){
   
   $scope.profile = {userName:"",firstName:""};
//   $scope.messages = [{subject:"Test",message:"Working Progress",to:'test@gmail.com',date:'03/22/2016'},
//                        {subject:"Test",message:"Working Progress",to:'test@gmail.com',date:'03/22/2016'},
//                        {subject:"Test",message:"Working Progress",to:'test@gmail.com',date:'03/22/2016'},
//                        {subject:"Test",message:"Working Progress",to:'test@gmail.com',date:'03/22/2016'},
//                        {subject:"Test",message:"Working Progress",to:'test@gmail.com',date:'03/22/2016'}];
//   
//   $scope.addMessage = function (){
//        $log.debug("FacilityController : Contact modal open");
//            $scope.message=null;
//            messageDataService.SetMessage($scope.message);
//            var modalInstance;
//            modalInstance = $modal.open({
//                templateUrl: "addMessage.html",
//                controller: 'MessageModalInstanceController'
//            });
//
//            modalInstance.result.then((function(message) {
//                $log.info("FacilityController : Contact added");
//                $scope.messages.push(message);                
//            }), function() {
//                $log.info("FacilityController : Modal dismissed");
//            });
//   };
//    
//    $scope.editMessage = function (index){
//        $scope.message = $scope.messages[index];
//        messageDataService.SetMessage($scope.message);
//        var modalInstance;
//            modalInstance = $modal.open({
//                templateUrl: "addMessage.html",
//                controller: 'MessageModalInstanceController'
//            });
//
//            modalInstance.result.then((function(message) {
//                $log.info("FacilityController : Contact added");
//                $scope.messages.push(message);                
//            }), function() {
//                $log.info("FacilityController : Modal dismissed");
//            });
//    };
};

})();
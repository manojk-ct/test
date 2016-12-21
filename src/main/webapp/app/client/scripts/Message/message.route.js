(function (){
    "use strict";
angular.module('app.message').config(function($stateProvider) {
        $stateProvider

        .state('manageMessage',{
                url:'/Message/manageMessage',
                templateUrl:'views/Message/manageMessage.html',
                controller:'MessageController'
        })
        ;
    });
})();



(function (){
    "use strict";
angular.module('app.payer')
        .config(function($stateProvider) {
        $stateProvider
        .state('managePayer',{
            url:'/Payer/managePayer',
            templateUrl:'views/payer/managePayer.html',
            controller:'PayerController'
        })
        ;
    });
})();


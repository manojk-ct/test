(function (){
    "use strict";
angular.module('app.affiliat')
        .config(function($stateProvider) {
        $stateProvider
        .state('manageAffiliat',{
            url:'/Affiliat/manageAffiliat',
            templateUrl:'views/Affiliat/manageAffiliated.html',
            controller:'AffiliatController'
        })
        ;
    });
})();



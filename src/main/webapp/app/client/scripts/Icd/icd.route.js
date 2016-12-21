(function (){
    "use strict";
angular.module('app.icd')
        .config(function($stateProvider) {
        $stateProvider
        .state('manageIcd',{
            url:'/Icd/manageIcd',
            templateUrl:'views/Icd/manageIcd.html',
            controller:'IcdController'
        })
        ;
    });
})();



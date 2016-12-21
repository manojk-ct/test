(function (){
    "use strict";
angular.module('app.technologist')
        .config(function($stateProvider) {
        $stateProvider
        .state('manageTechnologist',{
            url:'/Technologist/manageTechnologist',
            templateUrl:'views/Technologist/manageTechnologist.html',
            controller:'TechnologistController'
        })
        ;
    });
})();



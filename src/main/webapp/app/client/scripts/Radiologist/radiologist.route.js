(function (){
    "use strict";
angular.module('app.radiologist')
        .config(function($stateProvider) {
        $stateProvider
        .state('manageRadiologist',{
            url:'/Radiologist/manageRadiologist',
            templateUrl:'views/radiologist/manageRadiologist.html',
            controller:'RadiologistController'
            
        })
        .state('addRadiologyGroup',{
          url:'/radiologistGroup',
          templateUrl:'views/radiologist/addRadiologistGroup.html',
          controller:'RadiologistGroupController'
          
        })
        ;
    });
})();


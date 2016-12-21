(function (){
    "use strict";

angular.module('app.patient').config(function($stateProvider) {
        $stateProvider
       .state('addPatient',{
            url:'/Patient/addPatient',
            templateUrl:'views/Patient/addPatient.html',
            controller:'PatientAddController'
      }).state('managePatient',{
            url:'/Patient/managePatient',
            templateUrl:'views/Patient/managePatient.html',
            controller:'PatientListController'
      });
    });

})();


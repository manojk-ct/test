(function (){
    "use strict";
angular.module('app.facility').config(function($stateProvider) {
        $stateProvider
        .state('manageFacility',{
                url:'/Facility/manageFacility',
                templateUrl:'views/Facility/manageFacility.html',
                controller:'FacilityController'
        })
        ;
    });
})();



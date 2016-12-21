(function (){
    "use strict";
angular.module('app.profile').config(function($stateProvider) {
        $stateProvider

        .state('manageProfile',{
                url:'/Profile/manageProfile',
                templateUrl:'views/Profile/manageProfile.html',
                controller:'ProfileController'
        })
        ;
    });
})();



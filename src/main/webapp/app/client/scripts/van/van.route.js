(function (){
    "use strict";
angular.module('app.van').config(function($stateProvider) {
        $stateProvider
        .state('manageVan',{
                url:'/Van',
                templateUrl:'views/van/manageVan.html',
                controller:'VanController'
        });
    });
})();



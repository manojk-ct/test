(function (){
    "use strict";
angular.module('app.provider')
        .config(function($stateProvider) {
        $stateProvider
//        .state('addProvider',{
//          url:'/Provider/addProvider',
//          templateUrl:'views/provider/addProvider.html',
//          controller:'ProviderAddController'
//          
//        })
        .state('manageProvider',{
            url:'/Provider/manageProvider',
            templateUrl:'views/provider/manageProvider.html',
            controller:'ProviderController'

        })
//        .state('editProvider',{
//            url:'/Provider/editProvider/:providerId',
//            templateUrl:'views/provider/addProvider.html',
//            controller:'ProviderEditController'
//
//        })
//        .state('viewProvider',{
//            url:'/Provider/viewProvider/:providerId',
//            templateUrl:'views/provider/addProvider.html',
//            controller:'ProviderViewController'
//
//        })
        ;
    });
})();


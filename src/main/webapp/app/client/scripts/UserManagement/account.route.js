(function (){
    "use strict";
angular.module('app.account').config(function($stateProvider) {
        $stateProvider
        .state('500', {
                url: '/500',
                templateUrl:'views/pages/500.html'
        }).state('404', {
                url:'/404',
                templateUrl: 'views/pages/404.html'
        }).state('blank', {
                url:'/blank',
                templateUrl: 'views/pages/blank.html'
        }).state('forgot-password', {
                url:'/forgot-password',
                templateUrl: 'views/pages/forgot-password.html',
                controller:'forgotPasswordController'
        }).state('invoice', {
                url:'/invoice',
                templateUrl: 'views/pages/invoice.html'
        }).state('lock-screen', {
                url:'/lock-screen',
                templateUrl: 'views/pages/lock-screen.html'
        }).state('profile', {
                url:'/profile',
                templateUrl: 'views/pages/profile.html'
        }).state('signin', {
                url:'/signin',
                templateUrl: 'views/pages/signin.html',
                controller:'LoginController',
                controllerAs:'loginCtrl'
        }).state('signup', {
                url:'/signup',
                templateUrl: 'views/pages/signup.html'
        });
    }).run(function ($state){
        $state.go('signin');
    });
})();



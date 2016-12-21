(function (){
    "use strict";
angular.module('app.user')
        .config(function($stateProvider) {
        $stateProvider
//        .state('addUser',{
//          url:'/User/addUser',
//          templateUrl:'views/user/addUser.html',
//          controller:'UserAddController'
//          
//        })
        .state('manageUser',{
            url:'/User/manageUser',
            templateUrl:'views/user/manageUser.html',
            controller:'UserController'

        })
//        .state('editUser',{
//            url:'/User/editUser/:userId',
//            templateUrl:'views/user/addUser.html',
//            controller:'UserEditController'
//
//        })
//        .state('viewUser',{
//            url:'/User/viewUser/:userId',
//            templateUrl:'views/user/addUser.html',
//            controller:'UserViewController'
//
//        })
        ;
    });
})();


(function (){
    "use strict";
angular.module('app.reviewsystem').config(function($stateProvider) {
        $stateProvider

        .state('manageReviewSystem',{
                url:'/ReviewSystem/manageReviewSystem',
                templateUrl:'views/ReviewSystem/manageReviewSystem.html',
                controller:'ReviewSystemController'
        })
        ;
    });
})();



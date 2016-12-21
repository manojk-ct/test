(function (){
    "use strict";
angular.module('app.bodypart')
        .config(function($stateProvider) {
        $stateProvider
        .state('manageBodyPart',{
            url:'/Bodypart/manageBodyPart',
            templateUrl:'views/BodyParts/manageBodyPart.html',
            controller:'BodypartController'
        })
        ;
    });
})();



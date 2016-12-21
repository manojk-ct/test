(function (){
    "use strict";
angular.module('app.cpt')
        .config(function($stateProvider) {
        $stateProvider
        .state('manageCptCharges',{
            url:'/Cpt/manageCptCharges',
            templateUrl:'views/Cpt/manageCptCharges.html',
            controller:'CptChargeController'
        })
        .state('manageCptCode',{
            url:'/Cpt/manageCptCode',
            templateUrl:'views/Cpt/manageCptCode.html',
            controller:'CptCodeController'
        })
        .state('manageCptModifier',{
            url:'/Cpt/manageCptModifier',
            templateUrl:'views/Cpt/manageCptModifier.html',
            controller:'CptModifierController'
        })
        ;
    });
})();



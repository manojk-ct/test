(function (){
    "use strict";
angular.module('app.masterdata').config(function($stateProvider) {
        $stateProvider

        .state('manageMasterdata',{
                url:'/Masterdata/manageMasterdata',
                templateUrl:'views/Masterdata/manageMasterdata.html',
                controller:'MasterdataController'
        })
        ;
    });
})();



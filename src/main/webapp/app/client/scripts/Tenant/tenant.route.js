(function (){
    "use strict";
angular.module('app.tenant')
        .config(function($stateProvider) {
        $stateProvider
        .state('manageTenant',{
            url:'/Tenant/manageTenant',
            templateUrl:'views/Tenant/manageTenant.html',
            controller:'TenantController',
            resolve: {
                 permission: function (AuthorizationService,CONSTANT) {
                       return AuthorizationService.permissionCheck(CONSTANT.ROLESFORTENANT);
                   }
                   ,
                 countryServ :function (countryService){
                     return countryService.setCountries();
                   },
                 dispatchRegionService :function (dispatchRegionService){
                     return dispatchRegionService.setDispatchRegions();
                   }
             }
        });
    });
})();


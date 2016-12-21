(function (){
    "use strict";
angular.module('app.tenant')
        .factory('tenantService',tenantService);


tenantService.$inject =['$resource','CONSTANT'];
function tenantService($resource,CONSTANT){
    return $resource(CONSTANT.SERVICEURL + '/api/tenant/:tenantId', { tenantId: '@tenantId' }, {
        update: {
            method: 'PUT'
        }
    });
};
})();




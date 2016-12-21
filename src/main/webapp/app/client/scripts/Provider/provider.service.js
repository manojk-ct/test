(function (){
    "use strict";
angular.module('app.provider')
        .factory('providerService',providerService);


providerService.$inject =['$resource','CONSTANT'];
function providerService($resource,CONSTANT){
    return $resource(CONSTANT.SERVICEURL + '/api/provider/:providerId', { providerId: '@providerId' }, {
        update: {
            method: 'PUT'
        }
    });
};
})();




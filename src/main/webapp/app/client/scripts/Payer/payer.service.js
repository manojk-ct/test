(function (){
    "use strict";
angular.module('app.payer')
        .factory('payerService',payerService);

payerService.$inject =['$resource','CONSTANT'];
function payerService($resource,CONSTANT){
    return $resource(CONSTANT.SERVICEURL + '/api/payer/:payerId', { payerId: '@payerId' }, {
        update: {
            method: 'PUT'
        }
    });
};
})();




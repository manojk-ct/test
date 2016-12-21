(function (){
    "use strict";

angular.module('app.requisition')
        .factory('requisitionService',requisitionService);

requisitionService.$inject=['$resource','CONSTANT'];
function requisitionService($resource,CONSTANT){
    return $resource(CONSTANT.SERVICEURL + '/api/requisition/:requisitionId', { requisitionId: '@requisitionId' }, {
        update: {
            method: 'PUT'
        }
    });
};
})();
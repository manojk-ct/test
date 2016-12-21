(function (){
    "use strict";
angular.module('app.affiliat')
        .factory('affiliatService',affiliatService);


affiliatService.$inject =['$resource','CONSTANT'];
function affiliatService($resource,CONSTANT){
    return $resource(CONSTANT.SERVICEURL + '/api/affiliate/:affiliateId', { affiliateId: '@affiliateId' }, {
        update: {
            method: 'PUT'
        }
    });
};
})();




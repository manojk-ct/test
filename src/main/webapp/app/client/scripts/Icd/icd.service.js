(function (){
    "use strict";
angular.module('app.icd')
        .factory('icdService',icdService);


icdService.$inject =['$resource','CONSTANT'];
function icdService($resource,CONSTANT){
    return $resource(CONSTANT.SERVICEURL + '/api/icd/:icdId', { icdId: '@icdId' }, {
        update: {
            method: 'PUT'
        }
    });
};
})();




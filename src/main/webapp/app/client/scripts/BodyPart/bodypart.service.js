(function (){
    "use strict";
angular.module('app.bodypart')
        .factory('bodypartService',bodypartService);


bodypartService.$inject =['$resource','CONSTANT'];
function bodypartService($resource,CONSTANT){
    return $resource(CONSTANT.SERVICEURL + '/api/bodypart/:bodyPartId', { bodyPartId: '@bodyPartId' }, {
        update: {
            method: 'PUT'
        }
    });
};
})();




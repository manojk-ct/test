(function (){
    "use strict";
angular.module('app.radiologist')
        .factory('radiologistService',radiologistService)
        .factory('radiologistGroupService',radiologistGroupService);


radiologistService.$inject =['$resource','CONSTANT'];
radiologistGroupService.$inject =['$resource','CONSTANT'];

function radiologistService($resource,CONSTANT){
    return $resource(CONSTANT.SERVICEURL + '/api/radiologist/:radiologistId', { radiologistId: '@radiologistId' }, {
        update: {
            method: 'PUT'
        }
    });
};

function radiologistGroupService($resource,CONSTANT){
    return $resource(CONSTANT.SERVICEURL + '/api/radiologistgroup/:radiologyGroupId', { radiologyGroupId: '@radiologyGroupId' }, {
        update: {
            method: 'PUT'
        }
    });
};

})();




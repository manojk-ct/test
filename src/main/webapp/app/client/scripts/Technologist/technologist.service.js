(function (){
    "use strict";
angular.module('app.technologist')
        .factory('technologistService',technologistService);


technologistService.$inject =['$resource','CONSTANT'];
function technologistService($resource,CONSTANT){
    return $resource(CONSTANT.SERVICEURL + '/api/technologist/:technologistId', { technologistId: '@technologistId' }, {
        update: {
            method: 'PUT'
        }
    });
};
})();




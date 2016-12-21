(function (){
    "use strict";
angular.module('app.van')
        .factory('vanService',vanService);


vanService.$inject =['$resource'];
function vanService($resource){
    return $resource('/mobileris/api/van/:vanId', { vanId: '@vanId' }, {
        update: {
            method: 'PUT'
        }
    });
};
})();




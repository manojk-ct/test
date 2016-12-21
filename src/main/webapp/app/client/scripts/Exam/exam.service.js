(function (){
    "use strict";
angular.module('app.exam')
        .factory('examService',examService);


examService.$inject =['$resource','CONSTANT'];
function examService($resource,CONSTANT){
    return $resource(CONSTANT.SERVICEURL + '/api/bodyPartExam/:bodyPartExamId', { bodyPartExamId: '@bodyPartExamId' }, {
        update: {
            method: 'PUT'
        }
    });
};
})();




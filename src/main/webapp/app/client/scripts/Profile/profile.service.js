(function (){
    "use strict";
angular.module('app.profile')
        .factory('profileService',profileService);
    function profileService($resource,CONSTANT){
        return $resource(CONSTANT.SERVICEURL + '/api/profile/:profileId', {profileId: '@profileId'}, {
            update: {
                method: 'PUT'
            }
        });
    };
})();
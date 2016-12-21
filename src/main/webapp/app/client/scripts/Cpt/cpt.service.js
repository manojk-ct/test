(function (){
    "use strict";
angular.module('app.cpt')
        .factory('cptChargesService',cptChargesService)
        .factory('cptCodeService',cptCodeService)
        .factory('cptTimeDataService',cptTimeDataService)
        .factory('cptModifierService',cptModifierService);


cptChargesService.$inject =['$resource','CONSTANT'];
cptCodeService.$inject =['$resource','CONSTANT'];
cptTimeDataService.$inject =[];
cptModifierService.$inject =['$resource','CONSTANT'];

function cptChargesService($resource,CONSTANT){
    return $resource(CONSTANT.SERVICEURL + '/api/cptCharge/:cptChargeId', { cptChargeId: '@cptChargeId' }, {
        update: {
            method: 'PUT'
        }
    });
};
function cptCodeService($resource,CONSTANT){
    return $resource(CONSTANT.SERVICEURL + '/api/cptCode/:cptId', { cptId: '@cptId' }, {
        update: {
            method: 'PUT'
        }
    });
};
function cptTimeDataService(){
    var cptTime={};

    return{
        GetCptTime:GetCptTime,
        SetCptTime:SetCptTime
    };


    function GetCptTime(){
        return cptTime;
    };

    function SetCptTime(facilitycptTime){
        cptTime = facilitycptTime;
    };
};  
function cptModifierService($resource,CONSTANT){
    return $resource(CONSTANT.SERVICEURL + '/api/cptModifier/:cptModifierId', { cptModifierId: '@cptModifierId' }, {
        update: {
            method: 'PUT'
        }
    });
};
})();




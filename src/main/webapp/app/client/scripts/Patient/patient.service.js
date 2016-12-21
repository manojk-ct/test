(function (){
    "use strict";

angular.module('app.patient')
        .factory('insuranceDataService',insuranceDataService)
//        .factory('patientDataService',patientDataService)
        .factory('patientService',patientService);

patientService.$inject=['$resource','CONSTANT'];
function patientService($resource,CONSTANT){
    return $resource(CONSTANT.SERVICEURL + '/api/patient/:patientId', { patientId: '@patientId' }, {
        update: {
            method: 'PUT'
        }
    });
};

function insuranceDataService(){
         var insurance={};
        
        return{
            GetInsurance:GetInsurance,
            SetInsurance:SetInsurance
        };
       
        
        function GetInsurance(){
            return insurance;
        };
        
        function SetInsurance(insuranceData){
            insurance = insuranceData;
        };
    };  
    
})();
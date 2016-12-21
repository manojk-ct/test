(function (){
    "use strict";
angular.module('app.facility')
        .factory('facilityService',facilityService)
        .factory('dispatchRegionService',dispatchRegionService)
        .factory('contactService',contactService)
        .factory('facilityStateService',facilityStateService);

function facilityService($resource,CONSTANT){
    return $resource(CONSTANT.SERVICEURL + '/api/facility/:facilityId', {facilityId: '@facilityId'}, {
        update: {
            method: 'PUT'
        }
    });
};

function dispatchRegionService($resource,CONSTANT){
        var dispatchRegionUrl = $resource(CONSTANT.SERVICEURL + '/api/list/dispatch-regions');
        
        return{
            GetDispatchRegions:GetDispatchRegions
        };
       
        
        function GetDispatchRegions(){
            dispatchRegionUrl.query();
        };
//        return {
//            GetDispatchRegions:function (){
//                return dispatchRegionUrl.query();
//            }
//        };
};

    function contactService(){
         var contact={};
        
        return{
            GetContact:GetContact,
            SetContact:SetContact
        };
       
        
        function GetContact(){
            return contact;
        };
        
        function SetContact(facilitycontact){
            contact = facilitycontact;
        };
    };  
    
    function facilityStateService(stateService,$q){
        var serviceState=[];
        var billingState=[];
        
        return{
          GetServiceState: GetServiceState,
          GetBillingState: GetBillingState,
          SetServiceState: SetServiceState,
          SetBillingState: SetBillingState,
          serviceState:serviceState,
          billingState:billingState
        };
        
        function GetServiceState(){
            return serviceState;
        };
        function GetBillingState(){
            return billingState;
        };
        function SetServiceState(country){
            var deferred = $q.defer();
            stateService.query({country_id:country},function(data){
                 deferred.resolve(data);  
            serviceState = data;
            },function (){
                deferred.reject("Error: request returned status " ); 
            });
           return deferred.promise;
        };
        function SetBillingState(country){
            var deferred = $q.defer();
            stateService.query({country_id:country},function(data){
                deferred.resolve(data);      
            },function (error){
                deferred.reject("Error: request returned status "); 
            });
            return deferred.promise;
        };
        
    };

   
})();
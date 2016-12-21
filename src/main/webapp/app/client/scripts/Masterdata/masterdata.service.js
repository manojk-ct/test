(function (){
    "use strict";
angular.module('app.masterdata')
        .factory('masterdataService',masterdataService)
        .factory('dataService',dataService);
    function masterdataService($resource,CONSTANT){
        return $resource(CONSTANT.SERVICEURL + '/api/masterdata/:masterdataId', {masterdataId: '@masterdataId'}, {
            update: {
                method: 'PUT'
            }
        });
    };
    function dataService(){
         var data={};
        
        return{
            GetData:GetData,
            SetData:SetData
        };
       
        
        function GetData(){
            return data;
        };
        
        function SetData(facilitydata){
            data = facilitydata;
        };
    };  
})();
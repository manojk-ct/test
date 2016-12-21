(function (){
    "use strict";
angular.module('app.message')
        .factory('messageService',messageService)
        .factory('messageDataService',messageDataService);

    function messageService($resource,CONSTANT){
        return $resource(CONSTANT.SERVICEURL + '/api/message/:messageId', {messageId: '@messageId'}, {
            update: {
                method: 'PUT'
            }
        });
    };
    function messageDataService(){
        var message={};
        
        return{
            GetMessage:GetMessage,
            SetMessage:SetMessage
        };
        function GetMessage(){
            return message;
        };
        
        function SetMessage(messageData){
            message = messageData;
        };
    };  
})();
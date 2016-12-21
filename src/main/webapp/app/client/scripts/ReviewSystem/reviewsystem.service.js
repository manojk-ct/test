(function (){
    "use strict";
angular.module('app.reviewsystem')
        .factory('reviewsystemService',reviewsystemService)
        .factory('groupService',groupService)
        .factory('questionService',questionService)
        .factory('groupDataService',groupDataService)
        .factory('questionDataService',questionDataService);
    function reviewsystemService($resource,CONSTANT){
        return $resource(CONSTANT.SERVICEURL + '/api/reviewsystem/:reviewsystemId', {reviewsystemId: '@reviewsystemId'}, {
            update: {
                method: 'PUT'
            }
        });
    };
    
    function groupService($resource,CONSTANT){
        return $resource(CONSTANT.SERVICEURL + '/api/group/:groupId', {groupId: '@groupId'}, {
            update: {
                method: 'PUT'
            }
        });
    };
    function questionService($resource,CONSTANT){
        return $resource(CONSTANT.SERVICEURL + '/api/question/:questionId', {questionId: '@questionId'}, {
            update: {
                method: 'PUT'
            }
        });
    };
    
    function groupDataService(){
        var group={};
        
        return{
            GetGroup:GetGroup,
            SetGroup:SetGroup
        };
       
        
        function GetGroup(){
            return group;
        };
        
        function SetGroup(groupData){
            group = groupData;
        };
    }; 
    
    function questionDataService(){
        var question={};
        
        return{
            GetQuestion:GetQuestion,
            SetQuestion:SetQuestion
        };
       
        
        function GetQuestion(){
            return question;
        };
        
        function SetQuestion(questionData){
            question = questionData;
        };
    }; 
})();
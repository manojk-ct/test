(function (){
    "use strict";
angular.module('app.exam')
        .config(function($stateProvider) {
        $stateProvider
        .state('manageExam',{
            url:'/Exam/manageExam',
            templateUrl:'views/Exam/manageExam.html',
            controller:'ExamController'
        })
        ;
    });
})();


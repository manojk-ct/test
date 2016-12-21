(function (){
    "use strict";

angular.module('app.requisition').config(function($stateProvider) {
        $stateProvider
       .state('addRequisition',{
            url:'/Requisition/addRequisition',
            templateUrl:'views/requisition/addRequisition.html',
            controller:'RequisitiontAddController'
      }).state('manageRequisition',{
            url:'/Requisition/manageRequisition',
            templateUrl:'views/requisition/manageRequisition.html'
      });
    });

})();


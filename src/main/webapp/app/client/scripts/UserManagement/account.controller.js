(function (){
    "use strict";
    angular.module('app.account')
        .controller('InvoiceController',InvoiceController)
        .controller('forgotPasswordController',forgotPasswordController)
        .controller('LoginController',LoginController);
InvoiceController.$inject =['$window'];
LoginController.$inject =['sessionService','$state'];
forgotPasswordController.$inject =['$scope','sessionService','$state'];


function InvoiceController($window) {
    var vm = this;
      return vm.printInvoice = function() {
        var originalContents, popupWin, printContents;
        printContents = document.getElementById('invoice').innerHTML;
        originalContents = document.body.innerHTML;
        popupWin = window.open();
        popupWin.document.open();
        popupWin.document.write('<html><head><link rel="stylesheet" type="text/css" href="styles/main.css" /></head><body onload="window.print()">' + printContents + '</html>');
        return popupWin.document.close();
      };
    };
    
function forgotPasswordController($scope,sessionService,$state){
    $scope.reset = function (forgotPasswordStatus){
        if(!forgotPasswordStatus){
            alert('Email is required');
        }else {
            
        }
    };
};

function LoginController(sessionService,$state){     
    var vm = this;  
    vm.user = null;
    var loginstatus = sessionService.isLoggedIn();
    if(loginstatus)
    {
        $state.go('dashboard');
    } 
    vm.Login = function (loginStatus){
        if(!loginStatus)
        {
            alert('username and password is required');
        }else{
                var user = angular.copy(vm.user);
                sessionService.login(user);

        }

    };
    
  };
})();



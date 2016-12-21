(function() {
  'use strict';
  angular.module('app.controllers', []).controller('AppCtrl', [
    '$scope', '$rootScope', function($scope, $rootScope) {
      var $window;
      $window = $(window);
      $scope.main = {
        brand: 'Mobile RIS',
        name: 'zCon'
      };
      $scope.pageTransitionOpts = [
        {
          name: 'Fade up',
          "class": 'animate-fade-up'
        }, {
          name: 'Scale up',
          "class": 'ainmate-scale-up'
        }, {
          name: 'Slide in from right',
          "class": 'ainmate-slide-in-right'
        }, {
          name: 'Flip Y',
          "class": 'animate-flip-y'
        }
      ];
      $scope.admin = {
        layout: 'wide',
        menu: 'vertical',
        fixedHeader: true,
        fixedSidebar: true,
        pageTransition: $scope.pageTransitionOpts[0]
      };
      $scope.$watch('admin', function(newVal, oldVal) {
        if (newVal.menu === 'horizontal' && oldVal.menu === 'vertical') {
          $rootScope.$broadcast('nav:reset');
          return;
        }
        if (newVal.fixedHeader === false && newVal.fixedSidebar === true) {
          if (oldVal.fixedHeader === false && oldVal.fixedSidebar === false) {
            $scope.admin.fixedHeader = true;
            $scope.admin.fixedSidebar = true;
          }
          if (oldVal.fixedHeader === true && oldVal.fixedSidebar === true) {
            $scope.admin.fixedHeader = false;
            $scope.admin.fixedSidebar = false;
          }
          return;
        }
        if (newVal.fixedSidebar === true) {
          $scope.admin.fixedHeader = true;
        }
        if (newVal.fixedHeader === false) {
          $scope.admin.fixedSidebar = false;
        }
      }, true);
      return $scope.color = {
        primary: '#5B90BF',
        success: '#A3BE8C',
        info: '#B48EAD',
        infoAlt: '#AB7967',
        warning: '#EBCB8B',
        danger: '#BF616A',
        gray: '#DCDCDC'
      };
      
      $scope.goToTop = function (){
          alert('error');
      };
      
      
    }
  ]).controller('HeaderCtrl', ['$scope','sessionService', function($scope,sessionService) {
//        $scope.isLoggedIn = SessionService.isLoggedIn();
        $scope.sessionService = sessionService;
        $scope.Logout = function (){
            sessionService.logout();
        };
          
  }]).controller('NavContainerCtrl', ['$scope', function($scope) {
      
  }]).controller('NavCtrl', function($scope, taskStorage, filterFilter,sessionService,CONSTANT) {
      var tasks;
      $scope.sessionService = sessionService;
      $scope.isLoggedIn = sessionService.isLoggedIn();
      $scope.role = sessionService.getUserRole();
      $scope.constant = CONSTANT;
      tasks = $scope.tasks = taskStorage.get();
      $scope.taskRemainingCount = filterFilter(tasks, {
        completed: false
      }).length;
      return $scope.$on('taskRemaining:changed', function(event, count) {
        return $scope.taskRemainingCount = count;
      });
      
//      $scope.isAuthorised = function (page){
//          
//          switch (role){
//              case 'ROLE_SUPERADMIN':
//                    for (var i = 0; i < max; i++) {
//                        
//                    }
//                  break;
//          }
//      };
      
      var Roles =[{mainMenu:'Dashboard',subMenu:[]},{mainMenu:'Care Network',subMenu:[]},{mainMenu:'Medical Record Setup',subMenu:[]},{mainMenu:'Dashboard',subMenu:[]}];
    }
  ).controller('DashboardCtrl', ['$scope','sessionService','$state','countryService','countryServ' ,function($scope,sessionService,$state,countryService,countryServ) {
          
        //$scope.sessionService = SessionService;
        //$scope.Logout = function (){
//            $scope.sessionService = SessionService;
//           // console.log($scope.sessionService.loginstatus.status);
//            $scope.sessionService.isLoggedIn();
        //};
        
      //var login= SessionService.isLoggedIn();
       //if(!login)
       //{
         //  $state.go('signin');
       //}
       $scope.countryService = countryService;
       $scope.countryServ = $scope.countryService;
       $scope.countryService.countries = countryServ;
//       countryService.SetCountries();
  }]);
 
}).call(this);

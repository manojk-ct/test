(function() {
  'use strict';
    angular.module('app', ['ngRoute','ui.router','ui.bootstrap','ngResource','ngFileUpload','moment-picker',
                            'app.controllers', 'app.directives', 'app.localization','angularSpinner',
                            'app.nav', 'app.task','app.ui.form.directives','angular-confirm','angularMoment',
                            'app.facility','app.patient','app.tenant','app.account',
                            'app.common','app.provider','app.bodypart','app.exam','app.payer',
                            'app.radiologist','app.user','ui-notification','app.affiliat','app.icd',
                            'app.technologist','app.cpt','app.van','app.requisition','app.message',
                            'app.profile','app.masterdata','app.reviewsystem'])
          .config(function($stateProvider,$logProvider,$provide,$httpProvider) {
                $httpProvider.interceptors.push('tokenAuthInterceptor');
                $httpProvider.defaults.withCredentials = true;
                $httpProvider.defaults.useXDomain = true;
                $logProvider.debugEnabled(true);
                
                $provide.decorator('$log', function ($delegate) {
                    var date = new Date();                   
                    // Keep track of the original debug method.
                    var origDebug = $delegate.debug;
                    var origInfo = $delegate.info;
                    var origError = $delegate.error;
                    $delegate.debug = function () {
                        var args = [].slice.call(arguments);
                        args[0] = ['[DEBUG]: ', date, ': ', args[0]].join('');

                        // Send on our enhanced message to the original debug method.
                        origDebug.apply(null, args);
                            //origDebug = enable;
                    };
                    $delegate.info = function () {
                        var args = [].slice.call(arguments);
                        args[0] = ['[INFO]: ', new Date().toLocaleString(), ': ', args[0]].join('');

                        // Send on our enhanced message to the original debug method.
                        origInfo.apply(null, args);
                    };
                    $delegate.error = function () {
                        var args = [].slice.call(arguments);
                        args[0] = ['[ERROR]: ', new Date().toLocaleString(), ': ', args[0]].join('');

                        // Send on our enhanced message to the original debug method.
                        origError.apply(null, args);
                    };

                    return $delegate;
                });
                $provide.decorator("$exceptionHandler",function ($delegate) {
                    return function (exception, cause) {
                        exception.message = "Some error has occured. Please try again, if error persist then please contact help desk: [" + exception.message + "]";
                        $delegate(exception, cause);
                        alert(exception.message);
                    };
                });
                $stateProvider.state('dashboard', {
                      url: '/dashboard',
                      templateUrl:'views/dashboard.html',
                      controller:'DashboardCtrl'
                      ,
                      resolve: {
                          permission: function (AuthorizationService,CONSTANT) {
                                return AuthorizationService.permissionCheck(CONSTANT.ROLES);
                            }
                            ,
                          countryServ :function (countryService){
                              return countryService.setCountries();
                            },
                          dispatchRegionService :function (dispatchRegionService){
                              return dispatchRegionService.setDispatchRegions();
                            }
                      }
                })
                .state('reports',{
                     url: '/reports',
                    templateUrl:'views/dashboard.html'
                })
                .state('manageCase',{
                     url: '/manageCase',
                    templateUrl:'views/dashboard.html'
                })
                .state('manageSchedule',{
                     url: '/manageSchedule',
                    templateUrl:'views/dashboard.html'
                })
                ;
          }).run(function ($window,$state){
//                alert("test msg");
                $window.onbeforeunload = function () {
                        $state.go('dashboard');
                    };
          }).factory('$exceptionHandler',function ($log){
               return function (exception, cause) {
                    $log.error(exception, cause);
                };
          }).factory('AuthorizationService', function ($log, $q, sessionService, $state) {
            return {
                permissionCheck: function (roleCollection) {
                    var deferred = $q.defer();
                    var ifPermissionPassed = false;
                    angular.forEach(roleCollection,function (role){
                        if (sessionService.getUserRole() === role) {
                            ifPermissionPassed = true;
                        }
                    });
                    
                    if (!ifPermissionPassed) {
                            $log.debug("Resolved the state change watch");
                            deferred.reject();
                            sessionService.logout();
                    } else {
                        deferred.resolve();
                    }
                    return deferred.promise;
                }
            };
        }).directive("zcscroll", function ($window) {
            return function(scope, element, attrs) {
                angular.element($window).bind("scroll", function() {
                     if (this.pageYOffset >= 100) {
                         scope.boolChangeClass = true;
                         console.log('Scrolled below header.');
                     } else {
                         scope.boolChangeClass = false;
                         console.log('Header is in view.');
                     }
                    scope.$apply();
                });
            };
        });
      }).call(this);



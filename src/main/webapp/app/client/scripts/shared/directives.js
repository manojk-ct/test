(function() {
  'use strict';
  angular.module('app.directives', []).directive('imgHolder', [
    function() {
      return {
        restrict: 'A',
        link: function(scope, ele, attrs) {
          return Holder.run({
            images: ele[0]
          });
        }
      };
    }
  ]).directive('customPage', function() {
    return {
      restrict: "A",
      controller: [
        '$scope', '$element', '$location', function($scope, $element, $location) {
          var addBg, path;
          path = function() {
            return $location.path();
          };
          addBg = function(path) {
            $element.removeClass('body-wide body-err body-lock body-auth');
            switch (path) {
              case '/404':
              case '/404':
              case '/500':
                return $element.addClass('body-wide body-err');
              case '/signin':
              case '/signup':
              case '/forgot-password':
                return $element.addClass('body-wide body-auth');
              case '/lock-screen':
                return $element.addClass('body-wide body-lock');
            }
          };
          addBg($location.path());
          return $scope.$watch(path, function(newVal, oldVal) {
            if (newVal === oldVal) {
              return;
            }
            return addBg($location.path());
          });
        }
      ]
    };
  }).directive('uiColorSwitch', [
    function() {
      return {
        restrict: 'A',
        link: function(scope, ele, attrs) {
          return ele.find('.color-option').on('click', function(event) {
            var $this, hrefUrl, style;
            $this = $(this);
            hrefUrl = void 0;
            style = $this.data('style');
            if (style === 'loulou') {
              hrefUrl = 'styles/main.css';
              $('link[href^="styles/main"]').attr('href', hrefUrl);
            } else if (style) {
              style = '-' + style;
              hrefUrl = 'styles/main' + style + '.css';
              $('link[href^="styles/main"]').attr('href', hrefUrl);
            } else {
              return false;
            }
            return event.preventDefault();
          });
        }
      };
    }
  ]).directive('goBack', [
    function() {
      return {
        restrict: "A",
        controller: [
          '$scope', '$element', '$window', function($scope, $element, $window) {
            return $element.on('click', function() {
              return $window.history.back();
            });
          }
        ]
      };
    }
  ]).directive('zcConfirmClick', [
        function(){
            return {
                priority: 1,
                terminal: true,
                link: function (scope, element, attr) {
                    var msg = attr.ngConfirmClick || "Are you sure?";
                    var clickAction = attr.ngClick;
                    element.bind('click',function (event) {
                        if ( window.confirm(msg) ) {
                            scope.$eval(clickAction);
                        }
                    });
                }
            };
    }])
//.directive('zcConfirm',function (){
//      return{
//          restrict: 'A',
//          template: '<div class="modal-header">' +
//'  <h3>Do you want to delete ?</h3>' +
//'   </div>' +
//'   <div class="modal-footer">' +
//'        <button class="btn btn-danger btn-round" ng-click="cancel()"> <span class="glyphicon glyphicon-remove"></span> &nbsp; No</button> ' +
//'          <button class="btn btn-success btn-round" ng-click="ok()"> <span class="glyphicon glyphicon-ok"></span> &nbsp; Yes</button> ' +
//'            <button type="button" class = "close" data-dismiss="modal" aria-hidden="true" ng-click="cancel()" > Cancel </button>' +
//'              </div> ',
//    controller:function ($scope){
//        
//    }
//      };
//  })
  ;

}).call(this);

(function (){
    "use strict";

angular.module('app.user')
        .controller('UserController',UserController)
        .controller('UserAddController',UserAddController)
        .controller('UserEditController',UserEditController)
        .controller('UserViewController',UserViewController);


UserController.$inject =['$scope','sessionService','$state','userService','$filter','$log','CONSTANT','countryService','stateService','logger','Upload','$http'];
UserAddController.$inject =['$scope','sessionService','$state','userService','CONSTANT','countryService','stateService','Notification','$filter'];
UserEditController.$inject =['$scope','sessionService','$state','userService','CONSTANT','countryService','stateService','$stateParams','Notification','$filter'];
UserViewController.$inject =['$scope','sessionService','$state','userService','CONSTANT','countryService','stateService','$stateParams','Notification','$filter'];


function UserController($scope,sessionService,$state,userService,$filter,$log,CONSTANT,countryService,stateService,logger,Upload,$http){
    $log.info("Radiologist controller initiated");
    var init;
    var isLoggedIn= sessionService.isLoggedIn();
    $scope.users=[];
    $scope.user ={};
    $scope.constant = CONSTANT;
    $scope.countryService =countryService;
    $scope.currentTabMain =true;
    $scope.readStatus = false;
    $scope.formValidStatus=false;
    $scope.updateIndex= null;
    var tempUser={};
    var tempIndex;
    $scope.user.defaultImage = "g1.jpg";
    $scope.showSpinner = true;
    
    // To get list of user
    userService.query().$promise.then(function (data){
        $scope.users = data;
        $scope.showSpinner = false;
        $log.debug("UserController: Successfully get the list of Radiologist");
        init();
       
    }).catch(function (error){
        $scope.showSpinner = false;
        throw new Error(error.statusText);
        $log.error("UserController: " + error.statusText); 
    });
    
    // To get add user
    $scope.onClickAdd = function (){
        $log.debug("UserController: on-click of add user");
        $scope.page ="Add";
        $scope.currentTabMain =false;
        $scope.user ={};
        
        $scope.readStatus = false;
        $scope.formValidStatus=false;
    };
    
    // To get edit user
    $scope.onClickEdit =function (index){
        $log.debug("UserController: on-click of edit user");
        $scope.page ="Edit";
        $scope.currentTabMain =false;
        $scope.user = $scope.currentPageUsers[index];
        tempUser = angular.copy($scope.currentPageUsers[index]);
        tempIndex = index;
        $scope.readStatus = false;
        $scope.formValidStatus=false; 
        $scope.updateIndex = index;
        $scope.GetStates();
    };
    
    // To get view user
    $scope.onClickView =function (index){
        $log.debug("UserController: on-click of view user");
        $scope.page ="View";
        $scope.currentTabMain =false;
        $scope.user = $scope.currentPageUsers[index];
        tempUser = angular.copy($scope.currentPageUsers[index]);
        tempIndex = index;
        $scope.readStatus = true;
        $scope.formValidStatus=false;
        $scope.GetStates();
    };
    
    // To get back to list of user 
    $scope.onClickList = function (){
        $scope.currentPageUsers[tempIndex] = tempUser;
        $scope.currentTabMain=true;
    };
    
    // To get states
    $scope.GetStates = function (){      
        if($scope.user.countryId === undefined)
        {
            logger.logError('Please select the country');
        }else{
            console.log($scope.user.countryId);
            stateService.query({country_id:$scope.user.countryId}).$promise.then(function(response){               
                $scope.states =response;
                $log.debug("UserController: Successfully get the list of states");
            }).catch(function (error){
                 throw new Error(error.statusText);
                 $log.error("UserController: " + error.statusText); 
            });
        }
    };  
    
    // To delete user
    $scope.deleteUser = function (index){
        var user = $scope.users[index];  
        userService.delete({userId: user.userId}).$promise.then(function(){
            $log.debug("UserController: successfully deleted user");
            $scope.users.splice(index, 1);
              logger.logSuccess('Successfully deleted ');
              init();
        }).catch(function (error){
             throw new Error(error.statusText);
             $log.error("UserController: " + error.statusText); 
        });
    };
    
    $scope.uploadFiles = function (file,errFiles){
        alert(Upload.isFile(file));
        $scope.user.file = file;
        $scope.errFile = errFiles && errFiles[0];
    };
    
    // To save user
     $scope.Submit = function (userStatus){
        if(false)
        {
            $scope.formValidStatus=true;
            $log.debug("UserController: form data is not valid");
            logger.logError("Please fill the required field");
        }
        else{
                $scope.formValidStatus=false;
                if($scope.page === "Add"){
                        $scope.user.dateOfBirth = $filter('date')($scope.user.dateOfBirth,'yyyy-MM-dd');
                        var fd = new FormData();
                        fd.append('file', $scope.user.file);
                        fd.append('firstName', $scope.user.firstName);
                        fd.append('lastName', $scope.user.lastName);
                        fd.append('roleType', $scope.user.roleType);
                        fd.append('dateOfBirth', $scope.user.dateOfBirth);
                        fd.append('middleName', $scope.user.middleName);
                        fd.append('userName', $scope.user.userName);
                        fd.append('addressLine1', $scope.user.addressLine1);
                        fd.append('city', $scope.user.city);
                        fd.append('countryId', $scope.user.countryId);
                        fd.append('phone1', $scope.user.phone1);
                        fd.append('phone2', $scope.user.phone2);
                        fd.append('emailId', $scope.user.emailId);
                        fd.append('addressLine2', $scope.user.addressLine2);
                        fd.append('zipCode', $scope.user.zipCode);
                        fd.append('stateId', $scope.user.stateId);
                        fd.append('phoneExtension', $scope.user.phoneExtension);
                        fd.append('faxNumber', $scope.user.faxNumber);
                        
                        $http.post("/mobileris/api/userManagement", fd, {
                            transformRequest: angular.identity,
                            headers: {'Content-Type': undefined}
                        })
                     .success(function(){
                            $scope.currentTabMain =true;
                            alert("file upload success");
                     })
                     .error(function(){
                         alert("file upload error");
                     });
//                    userService.postData($scope.user).$promise.then(function (data){
//                        $log.debug("UserController: successfully added new user");
//                        $scope.users.push($scope.user);
//                        logger.logSuccess('Successfully added ');
//                        $scope.currentTabMain =true;
//                        $scope.currentTabMain ="listUser.html";
//                        init();
//                    }).catch(function (error){
//                         throw new Error(error.statusText);
//                         $log.error("UserController: " + error.statusText); 
//                    });                               
                }else if($scope.page === "Edit"){
                    
                        $scope.user.dateOfBirth = $filter('date')($scope.user.dateOfBirth,'yyyy-MM-dd');
                        var fd = new FormData();
                        fd.append('file', $scope.user.file);
                        fd.append('firstName', $scope.user.firstName);
                        fd.append('lastName', $scope.user.lastName);
                        fd.append('roleType', $scope.user.roleType);
                        fd.append('dateOfBirth', $scope.user.dateOfBirth);
                        fd.append('middleName', $scope.user.middleName);
                        fd.append('userName', $scope.user.userName);
                        fd.append('addressLine1', $scope.user.addressLine1);
                        fd.append('city', $scope.user.city);
                        fd.append('countryId', $scope.user.countryId);
                        fd.append('phone1', $scope.user.phone1);
                        fd.append('phone2', $scope.user.phone2);
                        fd.append('emailId', $scope.user.emailId);
                        fd.append('addressLine2', $scope.user.addressLine2);
                        fd.append('zipCode', $scope.user.zipCode);
                        fd.append('stateId', $scope.user.stateId);
                        fd.append('phoneExtension', $scope.user.phoneExtension);
                        fd.append('faxNumber', $scope.user.faxNumber);
                        $http.put("/mobileris/api/userManagement/"+$scope.user.userId, fd, {
                            transformRequest: angular.identity,
                            headers: {'Content-Type': undefined}
                        })
                        .success(function(){
                            $scope.currentTabMain =true;
                            alert("file upload success");
                        })
                        .error(function(){
                            alert("file upload error");
                        });
                    
                    
//                    userService.update($scope.user).$promise.then(function (data){
//                        if($scope.updateIndex !== null)
//                        {
//                            $log.debug("UserController: successfully updated user");
//                            $scope.users[$scope.updateIndex] =  $scope.user;
//                            $scope.updateIndex = null;
//                        }   
//                        logger.logSuccess('Successfully edited ');
//                        $scope.currentTabMain =true;
//                        init();
//                    }).catch(function (error){
//                         throw new Error(error.statusText);
//                         $log.error("UserController: " + error.statusText); 
//                    });
                }     
        };
    };
    
    // Date-Picker
    $scope.format = 'yyyy-dd-MM';
    $scope.today = function() {
         $scope.user.dateOfBirth = new Date();
    };
    $scope.clear = function() {
      $scope.user.dateOfBirth = null;
    };
    $scope.opendob = function($event) {
      $event.preventDefault();
      $event.stopPropagation();
      return $scope.openeddob = true;
    };
      
    $scope.dateOptions = {
      'year-format': "'yy'",
      'starting-day': 1
    }; 
    
    
    // Pagination
    $scope.searchKeywords = '';
    $scope.filteredUsers = [];
    $scope.row = '';
    $scope.select = function(page) {
        var end, start;
        start = (page - 1) * $scope.numPerPage;
        end = start + $scope.numPerPage;
        return $scope.currentPageUsers = $scope.filteredUsers.slice(start, end);
    };
    $scope.onFilterChange = function() {
        $scope.select(1);
        $scope.currentPage = 1;
        return $scope.row = '';
    };
    $scope.onNumPerPageChange = function() {
        $scope.select(1);
        return $scope.currentPage = 1;
    };
    $scope.onOrderChange = function() {
        $scope.select(1);
        return $scope.currentPage = 1;
    };
    $scope.search = function() {
        $scope.filteredUsers = $filter('filter')($scope.users, $scope.searchKeywords);
        return $scope.onFilterChange();
    };
    $scope.order = function(rowName) {
        if ($scope.row === rowName) {
          return;
        }
        $scope.row = rowName;
        $scope.filteredUsers = $filter('orderBy')($scope.users, rowName);
        return $scope.onOrderChange();
    };
    $scope.numPerPageOpt = [3, 5, 10, 20];
    $scope.numPerPage = $scope.numPerPageOpt[1];
    $scope.currentPage = 1;
    $scope.currentPageUsers = [];
    init = function() {
        $scope.search();
        return $scope.select($scope.currentPage);
    };
    return init();
};

function UserAddController($scope,sessionService,$state,userService,CONSTANT,countryService,stateService,Notification,$filter){
    $scope.constant = CONSTANT;
    $scope.countryService =countryService;
    $scope.page ="Add";
    $scope.readStatus = false;
    $scope.formValidStatus=false;
    $scope.GetStates = function (){      
        stateService.query({country_id:$scope.user.country}
            ,function(response){
                $scope.states =response;
            },function (){
            });
    };
    
    $scope.Submit = function (userStatus){
        if(!userStatus)
        {
            $scope.formValidStatus=true;
            alert('You have missed somthing');
        }
        else{
                userService.save($scope.user,function (data){
                    $state.go('manageUser');
                },function (error){
                    alert('Data is not stored');
                });

        }
        
    };
    
    
    $scope.format = 'yyyy-dd-MM';
    $scope.today = function() {
         $scope.user.dob = new Date();
      };
    $scope.clear = function() {
      $scope.user.dob = null;
    };
    $scope.disabled = function(date, mode) {
      return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
    };
    $scope.open = function($event) {
      $event.preventDefault();
      $event.stopPropagation();
      return $scope.opened = true;
    };

    $scope.dateOptions = {
      'year-format': "'yy'",
      'starting-day': 1
    };
};

function UserEditController($scope,sessionService,$state,userService,CONSTANT,countryService,stateService,$stateParams,Notification,$filter){
    $scope.constant = CONSTANT;
    $scope.countryService =countryService;
    $scope.page ="Edit";
    $scope.readStatus = false;
    $scope.formValidStatus=false;
    var init;
    var userId = $stateParams.userId;
    userService.get({userId:userId},function (userData){
        $scope.user = userData;
        init();
       },function (error){
           alert('Somthing went wrong please try again');
    });
    $scope.GetStates = function (){      
        
        stateService.query({country_id:$scope.user.country}
            ,function(response){
                $scope.states =response;
            },function (){
            });
    };
    
    $scope.Submit = function (userStatus){
        if(!userStatus)
        {
            $scope.formValidStatus=true;
            alert('You have missed somthing');
        }
        else{
                $scope.user.$update($scope.user,function (data){
                    Notification.success('Successfully edited ');
                    $state.go('manageUser');
                },function (error){
                    alert('Data is not stored');
                });

        }
        
    };
    
    init = function (){
        $scope.user.country=1;
        $scope.user.country=1;
        stateService.query({country_id:$scope.user.country},function(response){
            $scope.states =response;
        },function (){
        });
    };
    
    $scope.format = 'yyyy-dd-MM';
    $scope.today = function() {
         $scope.user.dob = new Date();
      };
    $scope.clear = function() {
      $scope.user.dob = null;
    };
    $scope.disabled = function(date, mode) {
      return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
    };
    $scope.open = function($event) {
      $event.preventDefault();
      $event.stopPropagation();
      return $scope.opened = true;
    };

    $scope.dateOptions = {
      'year-format': "'yy'",
      'starting-day': 1
    };
};

function UserViewController($scope,sessionService,$state,userService,CONSTANT,countryService,stateService,$stateParams,Notification,$filter){
        $scope.constant = CONSTANT;
        $scope.countryService =countryService;
        $scope.page ="View";
        $scope.readStatus = true;
        var userId = $stateParams.userId;
        userService.get({userId:userId},function (userData){
           $scope.user = userData;
           init();
        },function (error){
           alert('Somthing went wrong please try again');
        });
        init = function (){
            $scope.user.country=1;
            $scope.user.country=1;
            stateService.query({country_id:$scope.user.country},function(response){
                $scope.states =response;
            },function (){
            });
            
        };
};

})();
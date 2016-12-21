(function (){
    "use strict";
angular.module('app.tenant')
        .controller('TenantController',TenantController)
        .controller('TenantAddController',TenantAddController)
        .controller('TenantEditController',TenantEditController)
        .controller('TenantViewController',TenantViewController);

TenantController.$inject =['$scope','tenantService','$state','$filter','sessionService','stateService','countryService','logger','$log'];
TenantAddController.$inject =['$scope','tenantService','$state','sessionService','countryService','stateService','$filter','Notification'];
TenantEditController.$inject =['$scope','$stateParams','tenantService','$state','sessionService','countryService','stateService','$filter','Notification'];
TenantViewController.$inject =['$scope','$stateParams','tenantService','sessionService','$state','countryService','stateService','Notification'];

function TenantController($scope,tenantService,$state,$filter,sessionService,stateService,countryService,logger,$log){
    $log.info("TenantController initiated");
    var init;
    var login= sessionService.loginstatus;   
    $scope.tenants=[];
    $scope.status =['Active','Inactive'];
    $scope.countryService =countryService;
    $scope.currentTabMain=true;
    var tempTenant={};
    var tempIndex;
    $scope.showSpinner = true;
    
    // To get list of tenants
    tenantService.query().$promise.then(function (tenantData){
        $scope.tenants = tenantData;
        $scope.showSpinner = false;
        $log.debug("TenantController: Successfully get the list of tenant");
        init();
    }).catch(function (error){
        $scope.showSpinner = false;
        throw new Error(error.statusText);
        $log.error("TenantController: " + error.statusText); 
    });
     
     // To get add tenant
    $scope.onClickAdd = function (){
        $log.debug("TenantController: on-click of add tenant");
        $scope.page ="Add";
        $scope.currentTabMain=false;
        $scope.tenant ={};
        $scope.readStatus = false;
        $scope.formValidStatus=false;
    };
    
    // To get edit tenant
    $scope.onClickEdit =function (index){
        $log.debug("TenantController: on-click of edit tenant");
        $scope.page ="Edit";
        $scope.currentTabMain=false;
        $scope.tenant = $scope.currentPageTenants[index];
        tempTenant = angular.copy($scope.currentPageTenants[index]);
        tempIndex = index;
        $scope.readStatus = false;
        $scope.formValidStatus=false; 
        $scope.updateIndex = index;
        $scope.GetStates();
    };
    
    // To get view tenant
    $scope.onClickView =function (index){
        $log.debug("TenantController: on-click of view tenant");
        $scope.page ="View";
        $scope.currentTabMain=false;
        $scope.tenant = $scope.currentPageTenants[index];
        tempTenant = angular.copy($scope.currentPageTenants[index]);
        tempIndex = index;
        $scope.readStatus = true;
        $scope.formValidStatus=false;
        $scope.GetStates();
    };
    
    // To get back to list of tenant
    $scope.onClickList = function (){
        $scope.currentPageTenants[tempIndex] = tempTenant;
        $scope.currentTabMain=true;
    }; 
     
    // To delete tenant 
    $scope.deleteTenant = function (index){
        var tenant = $scope.tenants[index];
        tenantService.delete({tenantId: tenant.tenantId}).$promise.then(function (){
                $log.debug("TenantController: successfully deleted tenant");
                $scope.tenants.splice(index, 1);
                logger.logSuccess('Successfully deleted ');
                init();
        }).catch(function (error){
            throw new Error(error.statusText);
            $log.error("TenantController: " + error.statusText); 
        });
    };
    
    // To save tenant
    $scope.Submit = function (tenantStatus){
        if(!tenantStatus)
        {
            $scope.formValidStatus =true;
            $log.debug("TenantController: form data is not valid");
           logger.logError("Please fill the required field");
        }
        else{
                $scope.formValidStatus=false;
                if($scope.page === "Add"){
                    var sssDate = $scope.tenant.serviceStartDate;
                    var svuData = $scope.tenant.serviceValidUpto;

                    $scope.tenant.serviceStartDate = $filter('date')(sssDate,'yyyy-MM-dd');
                    $scope.tenant.serviceValidUpto = $filter('date')(svuData,'yyyy-MM-dd');

                    tenantService.save($scope.tenant).$promise.then(function (data){
                        if(data !== null)
                        {
                            $log.debug("TenantController: successfully added new tenant");
                            $scope.tenants.push(data);
                            logger.logSuccess('Successfully added ');
                            $scope.currentTabMain ="listTenant.html";
                            $scope.currentTabMain=false;
                            init();
                        }
                    }).catch(function (error){                    
                       throw new Error(error.statusText);
                       $log.error("TenantController: " + error.statusText); 
                    });
                }else if($scope.page === "Edit"){
                    var sssDate = $scope.tenant.serviceStartDate;
                    var svuData = $scope.tenant.serviceValidUpto;

                    $scope.tenant.serviceStartDate = $filter('date')(sssDate,'yyyy-MM-dd');
                    $scope.tenant.serviceValidUpto = $filter('date')(svuData,'yyyy-MM-dd');
                    tenantService.update($scope.tenant).$promise.then(function (){
                        if($scope.updateIndex !== null)
                        {
                            $log.debug("TenantController: successfully updated tenant");
                            $scope.tenants[$scope.updateIndex] =  $scope.tenant;
                            $scope.updateIndex = null;
                        }  
                        logger.logSuccess('Successfully edited ');
                        $scope.currentTabMain ="listTenant.html";
                        $scope.currentTabMain=false;
                        init();
                     }).catch(function (error){
                        throw new Error(error.statusText);
                        $log.error("TenantController: " + error.statusText); 
                     });
                }
        }
    };
    
    // To get states
    $scope.GetStates = function (){   
        if($scope.tenant.countryId === undefined)
        {
            logger.logError('Please select the country');
        }else{
            stateService.query({country_id:$scope.tenant.countryId}).$promise.then(function(response){               
                $scope.states =response;
            }).catch(function (error){
                throw new Error(error.statusText);
                $log.error("TenantController: " + error.statusText); 
            });
        }
    };
    
    
    // Date-Picker
    $scope.format = 'yyyy-dd-MM';
    $scope.today = function() {
         $scope.tenant.serviceStartDate = new Date();
         $scope.tenant.serviceValidUpto = new Date();
    };
    $scope.clear = function() {
      $scope.tenant.serviceStartDate = null;
      $scope.tenant.serviceValidUpto = null;
    };
    $scope.opensvu = function($event) {
      $event.preventDefault();
      $event.stopPropagation();
      return $scope.openedsvu = true;
    };
    $scope.openssd = function($event) {
      $event.preventDefault();
      $event.stopPropagation();
      return $scope.openedssd = true;
    };
      
    $scope.dateOptions = {
      'year-format': "'yy'",
      'starting-day': 1
    };   
     
    // Sub-Menues
    $scope.tabs = [{
            title :'Owner',
            url:'owner.html'
        },{
            title :'Administrator',
            url:'administrator.html'
        },{
            title :'Supervisor',
            url:'supervisor.html'
    }];
    $scope.currentTab = 'owner.html';
    $scope.onClickTab = function (tab){
        $scope.currentTab = tab.url;
    };
    $scope.isActiveTab = function(tabUrl) {
        return tabUrl === $scope.currentTab;
    };
    
    
    //pagination
    $scope.searchKeywords = '';
    $scope.filteredTenants = [];
    $scope.row = '';
    $scope.select = function(page) {
      var end, start;
      start = (page - 1) * $scope.numPerPage;
      end = start + $scope.numPerPage;
      
      return $scope.currentPageTenants = $scope.filteredTenants.slice(start, end);
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
      $scope.filteredTenants = $filter('filter')($scope.tenants, $scope.searchKeywords);
      return $scope.onFilterChange();
    };
    $scope.order = function(rowName) {
      if ($scope.row === rowName) {
        return;
      }
      $scope.row = rowName;
      $scope.filteredTenants = $filter('orderBy')($scope.tenants, rowName);
      return $scope.onOrderChange();
    };
    $scope.numPerPageOpt = [3, 5, 10, 20];
    $scope.numPerPage = $scope.numPerPageOpt[1];
    $scope.currentPage = 1;
    $scope.currentPageTenants = [];
    init = function() {
      $scope.search();
      return $scope.select($scope.currentPage);
    };
    return init();
    
};

function TenantAddController($scope,tenantService,$state,sessionService,countryService,stateService,$filter,Notification){
    $scope.countryService =countryService;
    var isLoggedIn= sessionService.loginstatus;
    $scope.formValidStatus =false;
    if(!isLoggedIn)
    {
        $state.go('signin');
    }
    $scope.tenant;
    $scope.page ="Add";
    $scope.readStatus = false;
    $scope.countries = countryService.getCountries();
    $scope.status =['Active','Inactive'];
         
    $scope.GetStates = function (){
        
        stateService.query({country_id:$scope.tenant.country}
            ,function(response){
//                $log.debug("TenantAddController : Service states are populated");
                $scope.states =response;
            },function (){
//                $log.error("TenantAddController : Service states are not populated");
            });
    };
    
    
    $scope.Submit = function (tenantStatus){
        if(!tenantStatus)
        {
            $scope.formValidStatus =true;
            alert('You have missed somthing');
        }
        else{
                var sssDate = $scope.tenant.serviceStartDate;
                var svuData = $scope.tenant.serviceValidUpto;
                
                $scope.tenant.serviceStartDate = $filter('date')(sssDate,'yyyy-MM-dd');
                $scope.tenant.serviceValidUpto = $filter('date')(svuData,'yyyy-MM-dd');
                
                tenantService.save($scope.tenant,function (data){
                    Notification.success('Successfully added ');
                    $state.go('manageTenant');
                },function (error){
                    alert('Data is not stored');
                });

        }
        
    };
    
    
    //Date Picker Code for Service start date and service valid upto
    $scope.format = 'yyyy-dd-MM';
    $scope.today = function() {
         $scope.tenant.serviceStartDate = new Date();
         $scope.tenant.serviceValidUpto = new Date();
    };
    $scope.clear = function() {
      $scope.tenant.serviceStartDate = null;
      $scope.tenant.serviceValidUpto = null;
    };
    $scope.disabled = function(date, mode) {
      return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
    };
    $scope.opensvu = function($event) {
      $event.preventDefault();
      $event.stopPropagation();
      return $scope.openedsvu = true;
    };
    $scope.openssd = function($event) {
      $event.preventDefault();
      $event.stopPropagation();
      return $scope.openedssd = true;
    };
      
    $scope.dateOptions = {
      'year-format': "'yy'",
      'starting-day': 1
    };   
      
    $scope.tabs = [{
            title :'Owner',
            url:'owner.html'
        },{
            title :'Administrator',
            url:'administrator.html'
        },{
            title :'Supervisor',
            url:'supervisor.html'
    }];
    $scope.currentTab = 'owner.html';
    $scope.onClickTab = function (tab){
        $scope.currentTab = tab.url;
    };
    $scope.isActiveTab = function(tabUrl) {
        return tabUrl == $scope.currentTab;
    };
};

function TenantEditController($scope,$stateParams,tenantService,$state,sessionService,countryService,stateService,$filter,Notification){ 
    $scope.countryService =countryService;
    var isLoggedIn= sessionService.loginstatus;
    $scope.formValidStatus =false;
       if(!isLoggedIn)
       {
           $state.go('signin');
           alert('You need to logged in first to access this page');
       }
        $scope.page ="Edit";
        var init;
        $scope.readStatus = false;
//        $scope.states = ['Option1','Option2'];
        $scope.status =['Active','Inactive'];
        $scope.countries = countryService.getCountries();
        var tenantId = $stateParams.tenantId;
        tenantService.get({tenantId:tenantId},function(tenantData){
            var temp = tenantData;
            temp.serviceStartDate = $filter('date')(tenantData.serviceStartDate,'yyyy-MM-dd');
            temp.serviceValidUpto = $filter('date')(tenantData.serviceValidUpto,'yyyy-MM-dd');
            $scope.tenant = temp;
            init();
        },function (){
            alert("Somthing Went Wrong!! Please try again");
        });
        $scope.Submit =function (tenantStatus){
        if(!tenantStatus)
        {
            $scope.formValidStatus=true;
            alert('You have missed somthing');
        }
        else{
//            var sssDate = $scope.tenant.serviceStartDate;
//            var svuData = $scope.tenant.serviceValidUpto;
//            $scope.tenant.serviceStartDate = $filter('date')(sssDate,'yyyy-MM-dd');
//            $scope.tenant.serviceValidUpto = $filter('date')(svuData,'yyyy-MM-dd');
//            console.log("Inside Tenant Edit controller serviceStartDate" +$scope.tenant.serviceStartDate);
//            console.log("Inside Tenant Edit controller serviceValidUpto" +$scope.tenant.serviceValidUpto);
            
            var sssDate = $scope.tenant.serviceStartDate;
            var svuData = $scope.tenant.serviceValidUpto;
                
            $scope.tenant.serviceStartDate = $filter('date')(sssDate,'yyyy-MM-dd');
            $scope.tenant.serviceValidUpto = $filter('date')(svuData,'yyyy-MM-dd');


              $scope.tenant.$update(function (){
                    Notification.success('Successfully edited ');
                    $state.go('manageTenant');
             },function (error){
                    alert("Somthing Went Wrong!! Please try again" + JSON.stringify(error));
             });
        }
         };
         var init = function (){
             $scope.tenant.country=1;          
            stateService.query({country_id:$scope.tenant.country},function(response){
//                $log.debug("FacilityEditController : Service states are populated");
                $scope.states =response;
            },function (){
//                $log.error("FacilityEditController : Service states are not populated");
            });
         };
         
        //Date Picker Code for Service start date and service valid upto
//        $scope.format = 'MM-dd-yyyy';
        $scope.format = 'yyyy-dd-MM';
        $scope.today = function() {
             $scope.tenant.serviceStartDate = new Date();
             $scope.tenant.serviceValidUpto = new Date();
          };
          $scope.clear = function() {
            $scope.tenant.serviceStartDate = null;
            $scope.tenant.serviceValidUpto = null;
          };
//          $scope.disabled = function(date, mode) {
//            return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
//          };
          $scope.opensvu = function($event) {
            $event.preventDefault();
            $event.stopPropagation();
            return $scope.openedsvu = true;
          };
          $scope.openssd = function($event) {
            $event.preventDefault();
            $event.stopPropagation();
            return $scope.openedssd = true;
          };

          $scope.dateOptions = {
            'year-format': "'yy'",
            'starting-day': 1
          };    
          $scope.tabs = [{
                title :'Owner',
                url:'owner.html'
            },{
                title :'Administrator',
                url:'administrator.html'
            },{
                title :'Supervisor',
                url:'supervisor.html'
            }];
            $scope.currentTab = 'owner.html';
            $scope.onClickTab = function (tab){
                $scope.currentTab = tab.url;
            };
            $scope.isActiveTab = function(tabUrl) {
                return tabUrl == $scope.currentTab;
        };
};

function TenantViewController($scope,$stateParams,tenantService,sessionService,$state,countryService,stateService,Notification){
        $scope.countryService =countryService;
        var isLoggedIn= sessionService.loginstatus;
        if(!isLoggedIn)
        {
            $state.go('signin');
        }
        var init;
        $scope.page ="View";
        $scope.readStatus = true;
         $scope.countries = countryService.getCountries();
        $scope.states = ['Option1','Option2'];
        $scope.status =['Active','Inactive'];
        var tenantId = $stateParams.tenantId;
        tenantService.get({tenantId:tenantId},function(tenantData){
            $scope.tenant = tenantData;
            
            init();
        },function (){
            alert("Somthing Went Wrong!! Please try again");
        });
        
        var init = function (){
            $scope.tenant.country=1;          
            stateService.query({country_id:$scope.tenant.country},function(response){
//                $log.debug("FacilityEditController : Service states are populated");
                $scope.states =response;
            },function (){
//                $log.error("FacilityEditController : Service states are not populated");
            });
        };
        $scope.tabs = [{
                title :'Owner',
                url:'owner.html'
            },{
                title :'Administrator',
                url:'administrator.html'
            },{
                title :'Supervisor',
                url:'supervisor.html'
            }];
            $scope.currentTab = 'owner.html';
            $scope.onClickTab = function (tab){
                $scope.currentTab = tab.url;
            };
            $scope.isActiveTab = function(tabUrl) {
                return tabUrl == $scope.currentTab;
        };
        
};
})();
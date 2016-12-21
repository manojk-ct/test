(function (){
    "use strict";

angular.module('app.affiliat')
        .controller('AffiliatController',AffiliatController);

AffiliatController.$inject =['$scope','affiliatService','countryService','stateService','$log','$filter','logger'];

function AffiliatController($scope,affiliatService,countryService,stateService,$log,$filter,logger){
    $log.info("Affiliate controller initiated");
    $scope.currentTabMain = true;
    $scope.currentTab = "settings.html";
    $scope.countryService = countryService;
    var init;
    $scope.affiliats =[];
    var tempAffiliat={};
    var tempIndex;
    $scope.showSpinner = true;
    //Get all affiliat company
    affiliatService.query().$promise.then(function (affiliatData){
        $scope.affiliats = affiliatData;
        $scope.showSpinner = false;
        $log.debug("AffiliateController: Successfully get the list of affiliate company");
        init();
    }).catch(function (error){
        $scope.showSpinner = false;
        throw new Error(error.statusText);
//        $log.error("AffiliateController: " + error.statusText); 
    });
    
    //on-click of add affiliat
    $scope.onClickAdd = function (){
        $log.debug("AffiliateController: on-click of add affiliate");
        $scope.page ="Add";
        $scope.currentTabMain =false;
        $scope.affiliat ={};
        $scope.readStatus = false;
        $scope.formValidStatus=false;
    };
    
    //on-click of edit affiliat
    $scope.onClickEdit =function (index){
        $log.debug("AffiliateController: on-click of edit affiliate");
        $scope.page ="Edit";
        $scope.currentTabMain =false;
        $scope.affiliat = $scope.currentPageAffiliats[index];
        tempAffiliat = angular.copy($scope.currentPageAffiliats[index]);
        tempIndex = index;
        $scope.readStatus = false;
        $scope.formValidStatus=false; 
        $scope.updateIndex = index;
        $scope.GetStates();
    };
    
    //on-click of edit affiliat
    $scope.onClickView =function (index){
        $log.debug("AffiliateController: on-click of view affiliate");
        $scope.page ="View";
        $scope.currentTabMain =false;
        $scope.affiliat = $scope.currentPageAffiliats[index];
        tempAffiliat = angular.copy($scope.currentPageAffiliats[index]);
        tempIndex = index;
        $scope.readStatus = true;
        $scope.formValidStatus=false;
        $scope.GetStates();
    };
    
    // To get back to list of affiliat company
    $scope.onClickList = function (){
        $scope.currentPageAffiliats[tempIndex] = tempAffiliat;
        $scope.currentTabMain =true;
    }; 
     
    // Get states on selection of country 
    $scope.GetStates = function (){   
        if($scope.affiliat.countryId === undefined)
        {
            logger.logError('Please select the country');
        }else{
            stateService.query({countryId_id:$scope.affiliat.countryId}).$promise.then(function(response){
                $log.debug("AffiliateController: successfully get states");
                $scope.states =response;
            }).catch(function (error){
                 throw new Error(error.statusText);
                 $log.error("AffiliateController: " + error.statusText); 
            });
        }
        
    };
     
    //Delete Technologist
    $scope.deleteAffiliat = function (index){
        var affiliat = $scope.affiliats[index];
        affiliatService.delete({affiliateId: affiliat.affiliateId}).$promise.then(function (){
                $log.debug("AffiliateController: successfully deleted affiliate");
                $scope.affiliats.splice(index, 1);
                logger.logSuccess('Successfully deleted ');
                init();
        }).catch(function (error){
             throw new Error(error.statusText);
             $log.error("AffiliateController: " + error.statusText); 
        });
    };
    
    
    $scope.Submit = function (affiliatStatus){
        if(!affiliatStatus)
        {
            $scope.formValidStatus =true;
            $log.debug("AffiliateController: form data is not valid");
            logger.logError("Please fill the required field");
        }
        else{
                $scope.formValidStatus=false;
                if($scope.page === "Add"){
                    affiliatService.save($scope.affiliat).$promise.then(function (data){
                        if(data !== null)
                        {
                            $log.debug("AffiliateController: successfully added new affiliate");
                            $scope.affiliats.push(data);
                            logger.logSuccess('Successfully added ');
                            $scope.currentTabMain =true;
                            init();
                        }
                    }).catch(function (error){
                            throw new Error(error.statusText);
                            $log.error("AffiliateController: " + error.statusText); 
                    });
                }else if($scope.page === "Edit"){
                    affiliatService.update($scope.affiliat).$promise.then(function (){
                        if($scope.updateIndex !== null)
                        {
                            $log.debug("AffiliateController: successfully updated affiliate");
                            $scope.affiliats[$scope.updateIndex] =  $scope.affiliat;
                            $scope.updateIndex = null;
                        }  
                        
                        logger.logSuccess('Successfully updated ');
                        $scope.currentTabMain =true;
                        init();
                     }).catch(function (error){
                             throw new Error(error.statusText);
                             $log.error("AffiliateController: " + error.statusText); 
                     });
                }
            }
        
    };
    
    //Date-Picker settings
    $scope.format = 'yyyy-dd-MM';
    $scope.today = function() {
         $scope.affiliat.service_start_date = new Date();
         $scope.affiliat.service_valid_upto = new Date();
    };
    $scope.dateOptions = {
      'year-format': "'yy'",
      'starting-day': 1
    };
    $scope.clear = function() {
      $scope.affiliat.service_start_date = null;
      $scope.affiliat.service_valid_upto = null;
    };
    $scope.open = function($event) {
      $event.preventDefault();
      $event.stopPropagation();
      return $scope.open = true;
    };
    
    //Sub-Menu
    $scope.tabs = [{
        title :'Settings',
        url:'settings.html'
    },{
        title :'Reciver/Submitter',
        url:'receiver.html'
    }];

    $scope.onClickTab = function (tab){
        $scope.currentTab = tab.url;
    };
    $scope.isActiveTab = function(tabUrl) {
        return tabUrl === $scope.currentTab;
    };
    
    //Pagination
    $scope.searchKeywords = '';
    $scope.filteredAffiliats = [];
    $scope.row = '';
    $scope.select = function(page) {
      var end, start;
      start = (page - 1) * $scope.numPerPage;
      end = start + $scope.numPerPage;
      
      return $scope.currentPageAffiliats = $scope.filteredAffiliats.slice(start, end);
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
      $scope.filteredAffiliats = $filter('filter')($scope.affiliats, $scope.searchKeywords);
      return $scope.onFilterChange();
    };
    $scope.order = function(rowName) {
      if ($scope.row === rowName) {
        return;
      }
      $scope.row = rowName;
      $scope.filteredAffiliats = $filter('orderBy')($scope.affiliats, rowName);
      return $scope.onOrderChange();
    };
    $scope.numPerPageOpt = [3, 5, 10, 20];
    $scope.numPerPage = $scope.numPerPageOpt[1];
    $scope.currentPage = 1;
    $scope.currentPageAffiliats = [];
    init = function() {
      $scope.search();
      return $scope.select($scope.currentPage);
    };
    return init();
};


})();
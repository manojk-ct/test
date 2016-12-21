(function (){
    "use strict";

angular.module('app.technologist')
        .controller('TechnologistController',TechnologistController);

TechnologistController.$inject =['$scope','technologistService','countryService','stateService','$log','$filter','logger'];

function TechnologistController($scope,technologistService,countryService,stateService,$log,$filter,logger){
    $log.info("TechnologistController initiated");
    $scope.currentTabMain = true;
    $scope.currentTab = "contactdetails.html";
    $scope.countryService = countryService;
    var init;
    $scope.technologists =[];
    var tempTechnologist={};
    var tempIndex;
    
    //Get list of technologist
    technologistService.query().$promise.then(function (technologistData){
        $scope.technologists = technologistData;
        $log.debug("TechnologistController: Successfully get the list of technologist");
        init();
    }).catch(function (error){
         throw new Error(error.statusText);
         $log.error("TechnologistController: " + error.statusText); 
    });
    
    //On-Click of Add
    $scope.onClickAdd = function (){
        $log.debug("TechnologistController: on-click of add technologist");
        $scope.page ="Add";
        $scope.currentTabMain =false;
        $scope.technologist ={};
        $scope.readStatus = false;
        $scope.formValidStatus=false;
    };
    
    //On-Click of Edit
    $scope.onClickEdit =function (index){
        $log.debug("TechnologistController: on-click of edit technologist");
        $scope.page ="Edit";
        $scope.currentTabMain =false;
        $scope.technologist = $scope.currentPageTechnologist[index];
        tempTechnologist = angular.copy($scope.currentPageTechnologist[index]);
        tempIndex = index;
        $scope.readStatus = false;
        $scope.formValidStatus=false; 
        $scope.updateIndex = index;
        $scope.GetStates();
    };
    
    //On-Click of view
    $scope.onClickView =function (index){
        $log.debug("TechnologistController: on-click of view technologist");
        $scope.page ="View";
        $scope.currentTabMain =true;
        $scope.technologist = $scope.currentPageTechnologist[index];
        tempTechnologist = angular.copy($scope.currentPageTechnologist[index]);
        tempIndex = index;
        $scope.readStatus = true;
        $scope.formValidStatus=false;
        $scope.GetStates();
    };
    
    //To get to List
    $scope.onClickList = function (){
        $scope.currentPageTechnologist[tempIndex] = tempTechnologist;
        $scope.currentTabMain =true;
    }; 
     
    //Get states on selection of country 
    $scope.GetStates = function (){      
        stateService.query({countryId_id:$scope.technologist.countryId}).$promise.then(function(response){
                $log.debug("TechnologistController: Successfully get the list of states");
                $scope.states =response;
            }).catch(function (error){
                 throw new Error(error.statusText);
                 $log.error("TechnologistController: " + error.statusText); 
            });
    };
     
    //Delete Method
    $scope.deleteTechnologist = function (index){
        var technologist = $scope.technologists[index];
        technologistService.delete({technologistId: technologist.technologistId}).$promise.then(function (){
                $log.debug("TechnologistController: successfully deleted technologist");
                $scope.technologists.splice(index, 1);
                logger.logSuccess('Successfully deleted technologist');
                init();
        }).catch(function (error){
            throw new Error(error.statusText);
            $log.error("TechnologistController: " + error.statusText); 
        });
    };
    
    //Add/Update Method 
    $scope.Submit = function (technologistStatus){
        if(!technologistStatus)
        {
            $scope.formValidStatus =true;
            $log.debug("TechnologistController: form data is not valid");
            logger.logError("Please fill the required field");
        }
        else{
                $scope.formValidStatus=false;
                if($scope.page === "Add"){

                    technologistService.save($scope.technologist).$promise.then(function (data){
                        $log.debug("TechnologistController: successfully added new technologist");
                        $scope.technologists.push($scope.technologist);
                        logger.logSuccess('Successfully added technologist');
                        $scope.currentTabMain =true;
                        init();
                    }).catch(function (error){
                        throw new Error(error.statusText);
                        $log.error("TechnologistController: " + error.statusText); 
                    });
                }else if($scope.page === "Edit"){
                    technologistService.update($scope.technologist).$promise.then(function (){
                        if($scope.updateIndex !== null)
                        {
                            $log.debug("TechnologistController: successfully updated technologist");
                            $scope.technologists[$scope.updateIndex] =  $scope.technologist;
                            $scope.updateIndex = null;
                        }  
                        logger.logSuccess('Successfully updated technologist');
                        $scope.currentTabMain =true;
                        init();
                     }).catch(function (error){
                            throw new Error(error.statusText);
                            $log.error("TechnologistController: " + error.statusText); 
                     });
                }
              
        }
        
    };
    
    //Date-Pickers
    $scope.format = 'yyyy-dd-MM';
    $scope.today = function() {
         $scope.technologist.service_start_date = new Date();
         $scope.technologist.service_valid_upto = new Date();
    };
    $scope.dateOptions = {
      'year-format': "'yy'",
      'starting-day': 1
    };
    $scope.clear = function() {
      $scope.technologist.service_start_date = null;
      $scope.technologist.service_valid_upto = null;
    };
    $scope.open = function($event) {
      $event.preventDefault();
      $event.stopPropagation();
      return $scope.open = true;
    };
     
    $scope.openDateOfJoining = function ($event){
        $event.preventDefault();
        $event.stopPropagation();
        return $scope.openDateOfJoiningStatus = true;
    };
    $scope.openLicenceCe = function ($event){
        $event.preventDefault();
        $event.stopPropagation();
        return $scope.openLicenceCeStatus = true;
    };
    $scope.openLicenceExpire = function ($event){
        $event.preventDefault();
        $event.stopPropagation();
        return $scope.openLicenceExpireStatus = true;
    };

    //Sub-Menues
    $scope.tabs = [{
        title :'Contact Details',
        url:'contactdetails.html'
    },{
        title :'Credentials',
        url:'credentials.html'
    },{
        title :'Speciality',
        url:'speciality.html'
    },{
        title :'Technique',
        url:'technique.html'
    },{
        title :'Availability',
        url:'availability.html'
    },{
        title :'Other Info',
        url:'otherInfo.html'
    }];
    $scope.onClickTab = function (tab){
        $scope.currentTab = tab.url;
    };
    $scope.isActiveTab = function(tabUrl) {
        return tabUrl === $scope.currentTab;
    };
    
    //pagination
    $scope.searchKeywords = '';
    $scope.filteredTechnologist = [];
    $scope.row = '';
    $scope.select = function(page) {
      var end, start;
      start = (page - 1) * $scope.numPerPage;
      end = start + $scope.numPerPage;
      
      return $scope.currentPageTechnologist = $scope.filteredTechnologist.slice(start, end);
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
      $scope.filteredTechnologist = $filter('filter')($scope.technologists, $scope.searchKeywords);
      return $scope.onFilterChange();
    };
    $scope.order = function(rowName) {
      if ($scope.row === rowName) {
        return;
      }
      $scope.row = rowName;
      $scope.filteredTechnologist = $filter('orderBy')($scope.technologists, rowName);
      return $scope.onOrderChange();
    };
    $scope.numPerPageOpt = [3, 5, 10, 20];
    $scope.numPerPage = $scope.numPerPageOpt[1];
    $scope.currentPage = 1;
    $scope.currentPageTechnologist = [];
    init = function() {
      $scope.search();
      return $scope.select($scope.currentPage);
    };
    return init();
};

})();
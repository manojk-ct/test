(function (){
    "use strict";
angular.module('app.facility')
        .controller('FacilityController',FacilityController)
        .controller('FacilityModalInstanceController',FacilityModalInstanceController);

FacilityController.$inject =['facilityService','$filter','sessionService','$state','$scope','$log','CONSTANT','facilityStateService','dispatchRegionService','countryService','contactService','$modal','logger'];
FacilityModalInstanceController.$inject =['$scope', '$modalInstance','contactService','$log'];
 

function FacilityController(facilityService,$filter,sessionService,$state,$scope,$log,CONSTANT,facilityStateService,dispatchRegionService,countryService,contactService,$modal,logger){
    $log.info("FacilityController : Inintiated");
    var init;
    var isLoggedIn= sessionService.isLoggedIn();
    $scope.countryService = countryService;
    $scope.constant = CONSTANT;
    $scope.readStatus = false;
    $scope.dispatchRegions = dispatchRegionService.getDispatchRegions();
    $scope.currentTab = 'administrator.html';
    $scope.currentTabMain = true;
    $scope.searchKeywords ="Please enter some value";
    $scope.facilities=[];
    $scope.showSpinner = true;
    var tempFacility={};
    var tempIndex;
    
    // To get list of facilities
    facilityService.query().$promise.then(function (data){
        $log.debug("FacilityController : Successfully get the list of facilities");
        $scope.facilities = data;
        init();
        $scope.showSpinner = false;
    }).catch(function (error){
        $scope.showSpinner = false;
        throw new Error(error.statusText);
        $log.error("FacilityController: " + error.statusText);
    });

    // To get add facility
    $scope.onClickAdd = function (){
        $log.debug("FacilityController: on-click of add facility");
        $scope.page ="Add";
        $scope.currentTabMain =false;
        $scope.currentTab = 'administrator.html';
        $scope.facility ={};
        $scope.facility.contacts =[];
        $scope.readStatus = false;
        $scope.formValidStatus=false;
    };
    
    // To get edit facility
    $scope.onClickEdit =function (index){        
        $log.debug("FacilityController: on-click of edit facility");
        $scope.page ="Edit";
        $scope.currentTabMain =false;
        $scope.currentTab = 'administrator.html';
        $scope.facility = $scope.currentPageFacilities[index];
        tempFacility = angular.copy($scope.currentPageFacilities[index]);
        tempIndex = index;
        $scope.readStatus = false;
        $scope.formValidStatus=false; 
        $scope.updateIndex = index;
        $scope.GetServiceStates();
        $scope.GetBillingStates();
        
    };
    
    // To get view facility
    $scope.onClickView =function (index){
        $log.debug("FacilityController: on-click of view facility");
        $scope.page ="View";
        $scope.currentTabMain =false;
        $scope.currentTab = 'administrator.html';
        $scope.facility = $scope.currentPageFacilities[index];
        tempFacility = angular.copy($scope.currentPageFacilities[index]);
        $scope.readStatus = true;
        $scope.formValidStatus=false;
        tempIndex = index;
        $scope.GetServiceStates();
        $scope.GetBillingStates();
    };
    
    // To get back to list of facility
    $scope.onClickList = function (){
        $scope.currentPageFacilities[tempIndex] = tempFacility;
        $scope.currentTabMain =true;
    };
    
    // To delete facility
    $scope.deleteFacility = function (index){   
        var facility = $scope.currentPageFacilities[index];  
        facilityService.delete({facilityId: facility.facilityId},function(){
            $log.debug("FacilityController : Successfully deleted facility");
            $scope.facilities.splice(index, 1);
            logger.logSuccess('Successfully deleted Facility');
            init();
        },function (error){
            throw new Error(error.statusText);
            $log.error("FacilityController: " + error.statusText);
        });
    };
    
    // To get all service details into billing details if billing address is same as service address
    $scope.IsBillingAddress = function (){
        if($scope.facility.isBillingLocation)
        {
          
            $scope.isBillingSame = true;
            $scope.facility.billingAddressLine1 = $scope.facility.serviceAddressLine1;
            $scope.facility.billingCity = $scope.facility.serviceCity;
            $scope.facility.billingCountryId =$scope.facility.serviceCountryId;
            $scope.facility.billingEmailId =$scope.facility.serviceEmailId;
            $scope.facility.billingLandLine1=$scope.facility.serviceLandLine1;
            $scope.facility.billingLandLine2=$scope.facility.serviceLandLine2;
            $scope.facility.billingAddressLine2=$scope.facility.serviceAddressLine2;
            $scope.facility.billingStateId=$scope.facility.serviceStateId;
            $scope.facility.billingZipCode=$scope.facility.serviceZipCode;
            $scope.facility.billingWorkPhone=$scope.facility.serviceWorkPhone;
            $scope.facility.billingFaxNumber1=$scope.facility.serviceFaxNumber1;
            $scope.facility.billingFaxNumber2=$scope.facility.serviceFaxNumber2;
            $scope.facility.billingLandLineExtension=$scope.facility.serviceLandLineExtension;
        }
        else
        {
            $scope.facility.billingAddressLine1 = null;
            $scope.facility.billingCity = null;
            $scope.facility.billingCountryId = null;
            $scope.facility.billingEmailId = null;
            $scope.facility.billingLandLine1= null;
            $scope.facility.billingLandLine2= null;
            $scope.facility.billingAddressLine2= null;
            $scope.facility.billingStateId= null;
            $scope.facility.billingZipCode= null;
            $scope.facility.billingWorkPhone= null;
            $scope.facility.billingFaxNumber1= null;
            $scope.facility.billingFaxNumber1= null;
            $scope.facility.billingLandLineExtension= null;
            $scope.isBillingSame = false;
        }
    };
    
    // To get service states
    $scope.GetServiceStates = function (){
        if($scope.facility.serviceCountryId === undefined)
        {
            logger.logError('Please select the service country');
        }else{
            facilityStateService.SetServiceState($scope.facility.serviceCountryId).then(function(data){
                $scope.serviceStates = data;
            }).catch(function (error){
                throw new Error(error.statusText);
                $log.error("FacilityController: " + error.statusText);
            });
        }
    };
    
    // To get billing states
    $scope.GetBillingStates = function (){
         if($scope.facility.billingCountryId === undefined)
        {
            logger.logError('Please select the billing country');
        }else{
            facilityStateService.SetBillingState($scope.facility.billingCountryId).then(function (data){
            $scope.billingStates = data;
            }).catch(function (error){
                 throw new Error(error.statusText);
                $log.error("FacilityController: " + error.statusText);
            });   
        }
           
    };
    
    // TO open modal to add facility contact
    $scope.open = function (){
            $log.debug("FacilityController : Contact modal open");
            $scope.contact=null;
            contactService.SetContact($scope.contact);
            var modalInstance;
            modalInstance = $modal.open({
                templateUrl: "facilitycontacts.html",
                controller: 'FacilityModalInstanceController'
            });

            modalInstance.result.then((function(contact) {
                $log.info("FacilityController : Contact added");
                $scope.facility.contacts.push(contact);                
            }), function() {
                $log.info("FacilityController : Modal dismissed");
            });
    };
    
    // To edit facility contact
    $scope.editFacilityContact = function (index){            
            $log.debug("FacilityController : Contact modal open to edit the contact");
            $scope.contact = $scope.facility.contacts[index];      
            contactService.SetContact($scope.contact);
            var modalInstance;
            modalInstance = $modal.open({
              templateUrl: "facilitycontacts.html",
              controller: 'FacilityModalInstanceController'
            });
        
            modalInstance.result.then((function(contact) {
                $log.info("FacilityController : Contact updated");
                $scope.facility.contacts[index] = contact;
                $scope.contact={};
            }), function() {
                $log.info("FacilityController : Modal dismissed");
            });
    };
    
    // To delete facility contact
    $scope.deleteFacilityContact = function (index){      
        $log.debug("FacilityController : Delete method called for facility contacts");
        $scope.facility.contacts.splice(index, 1);    
        $log.info("FacilityController : Facility contact deleted successfully");
    };
    
    // Sub-Menues
    $scope.tabs = [{
        title :'Administrator',
        url:'administrator.html'
    },{
        title :'Assistant Administrator',
        url:'assistant_administrator.html'
    },{
        title :'Director of Nursing',
        url:'director_nursing.html'
    },{
        title :'Assistant Director of Nursing',
        url:'assistant_director_nursing.html'
    }];
    $scope.onClickTab = function (tab){
        $scope.currentTab = tab.url;
    };
    $scope.isActiveTab = function(tabUrl) {
        return tabUrl === $scope.currentTab;
    };
    
    // To save facility
    $scope.Submit = function (formStatus){
       
        $log.debug("FacilityController : submit method called");
        if(!formStatus)
        {
             $scope.formValidStatus=true;
            $log.info("FacilityController : Form data is not valid");
            logger.logError("Please fill the required field");
        }
        else{           
                $log.debug("FacilityController : Form data is valid");
                if($scope.page === "Add"){
                    facilityService.save($scope.facility).$promise.then(function (data){
                        if(data !== null)
                        {
                            $scope.facilities.push(data);
                            $log.info("FacilityController : form data is successfully saved");
                            logger.logSuccess('Successfully added facility');
                            $scope.currentTabMain =true;
                            init();
                        }
                    }).catch(function (error){
                        $log.error("FacilityController : form data is not saved successfully");
                         throw new Error(error.statusText);
                    });
                 }else if($scope.page === "Edit"){
                        facilityService.update($scope.facility).$promise.then(function (){ 
                            if($scope.updateIndex !== null)
                            {
                                $scope.facilities[$scope.updateIndex] =  $scope.facility;
                                $scope.updateIndex = null;
                            }    
                            logger.logSuccess('Successfully updated facility ');
                            $log.info("FacilityEditController : Facility updated");
                            $scope.currentTabMain =true;
                            init();
                        }).catch(function (error){
                            $log.error("FacilityEditController : Facility is not updated" + error);
                             throw new Error(error.statusText);
                    });
                 }
                
        }       
    };
    
    //pagination
    $scope.searchKeywords = '';
    $scope.filteredFacilities = [];
    $scope.row = '';
    $scope.select = function(page) {
        var end, start;
        start = (page - 1) * $scope.numPerPage;
        end = start + $scope.numPerPage;
        return $scope.currentPageFacilities = $scope.filteredFacilities.slice(start, end);
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
        $scope.filteredFacilities = $filter('filter')($scope.facilities, $scope.searchKeywords);
//        $scope.filteredFacilities = $filter('filter')($scope.facilities, {facility_name:$scope.searchKeywords,pos_code:$scope.searchKeywords} );
        return $scope.onFilterChange();
    };
    $scope.order = function(rowName) {
        if ($scope.row === rowName) {
          return;
        }
        $scope.row = rowName;
        $scope.filteredFacilities = $filter('orderBy')($scope.facilities, rowName);
        return $scope.onOrderChange();
    };
    $scope.numPerPageOpt = [3, 5, 10, 20];
    $scope.numPerPage = $scope.numPerPageOpt[1];
    $scope.currentPage = 1;
    $scope.currentPageFacilities = [];
    init = function() {
        $scope.search();
        return $scope.select($scope.currentPage);
    };
    return init();
    
};

function FacilityModalInstanceController($scope,$modalInstance,contactService,$log){
        $log.debug("FacilityModalInstanceController : Initiated");
        $scope.contact =contactService.GetContact();
        $scope.ok = function() {
            $modalInstance.close($scope.contact);
        };
        $scope.cancel = function() {
            $modalInstance.dismiss("cancel");
        };
};
})();
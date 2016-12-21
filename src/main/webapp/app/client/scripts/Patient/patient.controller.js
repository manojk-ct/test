(function (){
    "use strict";

angular.module('app.patient')
        .controller('PatientListController',PatientListController)
        .controller('InsuranceModalInstanceController',InsuranceModalInstanceController);

PatientListController.$inject =['$scope','sessionService','$state','$modal','insuranceDataService','CONSTANT','countryService','patientService','$log','logger','stateService','$filter'];
InsuranceModalInstanceController.$inject =['$scope', '$modalInstance','$log','insuranceDataService','CONSTANT','$filter'];

function PatientListController($scope,sessionService,$state,$modal,insuranceDataService,CONSTANT,countryService,patientService,$log,logger,stateService,$filter){
     $log.info("Patient controller initiated");
    var init;
    var isLoggedIn= sessionService.isLoggedIn();
    $scope.constant = CONSTANT;
    $scope.countryService =countryService;
    $scope.patients=[];
    $scope.currentTabMain =true;
    $scope.readStatus = false;
    $scope.formValidStatus=false;
    var tempPatient={};
    var tempIndex;
    $scope.showSpinner = true;
    // To get list of Patients
    patientService.query().$promise.then(function (data){
        $scope.patients = data;
        $scope.showSpinner = false;
        $log.debug("PatientController: Successfully get the list of Patients");
        init();
    }).catch(function (error){
        $scope.showSpinner = false;
         throw new Error(error.statusText);
         $log.error("PatientController: " + error.statusText); 
    });
    
    // To get add Patient page
    $scope.onClickAdd = function (){
        $log.debug("PatientController: on-click of add Patient");
        $scope.page ="Add";
        $scope.currentTabMain =false;
        $scope.patient ={};
        $scope.patient.insurance =[];
        $scope.readStatus = false;
        $scope.formValidStatus=false;
    };
    
    // To get edit Patient page
    $scope.onClickEdit =function (index){
        $log.debug("PatientController: on-click of edit Patient");
        $scope.page ="Edit";
        $scope.currentTabMain =false;
        $scope.patient = $scope.currentPagePatients[index];
        tempPatient = angular.copy($scope.currentPagePatients[index]);
        tempIndex = index;
        $scope.readStatus = false;
        $scope.formValidStatus=false; 
        $scope.updateIndex = index;
        $scope.GetStates();
    };
    
    // To get view Patient
    $scope.onClickView =function (index){
        $log.debug("PatientController: on-click of view Patient");
        $scope.page ="View";
        $scope.currentTabMain =false;
        $scope.patient = $scope.currentPagePatients[index];
        tempPatient = angular.copy($scope.currentPagePatients[index]);
        tempIndex = index;
        $scope.readStatus = true;
        $scope.formValidStatus=false;
        $scope.GetStates();
    };
    
    // To get back to list of Patient page
    $scope.onClickList = function (){
        $scope.currentPagePatients[tempIndex] = tempPatient;
        $scope.currentTabMain =true;
    };
    
    // To delete Patient
    $scope.deletePatient = function (index){
        var patient = $scope.patients[index];  
        patientService.delete({patientId: patient.patientId}).$promise.then(function(data){
                $log.debug("PatientController: successfully deleted Patient");
                $scope.patients.splice(index, 1);
                logger.logSuccess('Successfully deleted  Patient');
                init();
        }).catch(function (error){
             throw new Error(error.statusText);
             $log.error("PatientController: " + error.statusText); 
        });
    };
    
    // To get states
    $scope.GetStates = function (){      
        if($scope.patient.countryId === undefined)
        {
            logger.logError('Please select the country');
        }else{
             stateService.query({country_id:$scope.patient.countryId}).$promise.then(function(response){
                $scope.states =response;
                $log.debug("PatientController: Successfully get the list of states");
            }).catch(function (error){
                 throw new Error(error.statusText);
                 $log.error("PatientController: " + error.statusText); 
            });
        }
    };
  
    // Date-Picker
    $scope.format = 'yyyy-dd-MM';
    $scope.today = function() {
         $scope.patient.dob = new Date();
    };
    $scope.clear = function() {
      $scope.patient.dob = null;
    };
    $scope.opendobp = function($event) {
        alert('');
      $event.preventDefault();
      $event.stopPropagation();
      return $scope.openeddobp = true;
    };
    
    // To save Patient
    $scope.Submit = function (patientStatus){
        if(!patientStatus)
        {
            $scope.formValidStatus=true;
            $log.debug("PatientController: form data is not valid");
            logger.logError("Please fill the required field");
        }
        else{
            $scope.formValidStatus=false;
                if($scope.page === "Add"){
//                $scope.patient.payerId = 6;
                $scope.patient.dob = $filter('date')($scope.patient.dob,'yyyy-MM-dd');
                patientService.save($scope.patient).$promise.then(function (data){
                    if(data !== null)
                    {
                        $scope.patients.push(data);
                        $log.debug("PatientController: successfully added new Patient");
                        logger.logSuccess('Successfully added Patient');
                        $scope.currentTabMain =true;
                        init();
                    }
                }).catch(function (error){
                     throw new Error(error.statusText);
                     $log.error("PatientController: " + error.statusText); 
                });
            }else if($scope.page === "Edit"){
                patientService.update($scope.Patient).$promise.then(function (){                    
                    logger.logSuccess('Successfully updated Patient ');
                    if($scope.updateIndex !== null)
                    {
                        $log.debug("PatientController: successfully updated Patient");
                        $scope.patients[$scope.updateIndex] =  $scope.patient;
                        $scope.updateIndex = null;
                        $scope.currentTabMain =true;
                    }     
                }).catch(function (error){
                     throw new Error(error.statusText);
                     $log.error("PatientController: " + error.statusText); 
                });
            }
        }
        
    };
    
    //Sub-Menus
    $scope.tabs = [{
        title :'Patient Information',
        url:'patientInformation.html'
    },{
        title :'Contact Details',
        url:'contactDetails.html'
    },{
        title :'Insurance Details',
        url:'insuranceDetails.html'
      
    },{
        title :'Notes',
        url:'notes.html'
    }];
    $scope.currentTab = 'patientInformation.html';
    $scope.onClickTab = function (tab)
    {
        $scope.currentTab = tab.url;
    };
    $scope.isActiveTab = function(tabUrl) {
        return tabUrl === $scope.currentTab;
    };
    
    $scope.insur = function (){
            var modalInstance;
            $scope.insurance=null;
            insuranceDataService.SetInsurance($scope.insurance);
            modalInstance = $modal.open({
            templateUrl: "insur_tabs.html",
            controller:'InsuranceModalInstanceController',
            windowClass: 'app-modal-window'
            });
            
            modalInstance.result.then((function(insurance) {
                
                $scope.patient.insurance.push(insurance);                
            }), function() {
                $log.info("PatientController : Modal dismissed");
            });
    };
    
    // Pagination
    $scope.searchKeywords = '';
    $scope.filteredPatients = [];
    $scope.row = '';
    $scope.select = function(page) {
        var end, start;
        start = (page - 1) * $scope.numPerPage;
        end = start + $scope.numPerPage;
        return $scope.currentPagePatients = $scope.filteredPatients.slice(start, end);
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
        $scope.filteredPatients = $filter('filter')($scope.patients, $scope.searchKeywords);
        return $scope.onFilterChange();
    };
    $scope.order = function(rowName) {
        if ($scope.row === rowName) {
          return;
        }
        $scope.row = rowName;
        $scope.filteredPatients = $filter('orderBy')($scope.patients, rowName);
        return $scope.onOrderChange();
    };
    $scope.numPerPageOpt = [5, 10, 20,100];
    $scope.numPerPage = $scope.numPerPageOpt[1];
    $scope.currentPage = 1;
    $scope.currentPagePatients = [];
    init = function() {
        $scope.search();
        return $scope.select($scope.currentPage);
    };
    return init();
};

function InsuranceModalInstanceController($scope,$modalInstance,$log,insuranceDataService,CONSTANT,$filter){
            $scope.currentInsuranceTab = 'primaryDetails.html';
            $scope.statusPrimaryDetails=true;
            $scope.constant = CONSTANT;
            $scope.onClickTabInsurance = function (tab)
            {
                $scope.currentInsuranceTab = tab.url;

                if(tab.url==='primaryDetails.html')
                {
                    $scope.statusPrimaryDetails=true;
                    $scope.statusGuarantor=false;
                    $scope.statusPolicyDetails=false;
                    $scope.statusClaimInfo=false;

                }
                 if(tab.url==='guarantorDetails.html')
                {
                    $scope.statusPrimaryDetails=false;
                    $scope.statusGuarantor=true;
                     $scope.statusPolicyDetails=false;
                    $scope.statusClaimInfo=false;
                }
                if(tab.url==='policyDetails.html')
                {
                     $scope.statusPrimaryDetails=false;
                    $scope.statusGuarantor=false;
                      $scope.statusPolicyDetails=true;
                    $scope.statusClaimInfo=false;
                }
                if(tab.url==='claimInfo.html')
                {
                    $scope.statusPrimaryDetails=false;
                    $scope.statusGuarantor=false;
                    $scope.statusPolicyDetails=false;
                    $scope.statusClaimInfo=true;
                }
            };
            $scope.isActiveTab = function(tabUrl) 
            {
                 return tabUrl === $scope.currentInsuranceTab;
            };


        $scope.insurancetabs = [
            {
                title :'Insurance Details',
                url:'primaryDetails.html'

            },{
                title :'Guarantor Details',
                url:'guarantorDetails.html'
            },{
                title :' Policy Details',
                url:'policyDetails.html'
            },{
                title :'Claim Info',
                url:'claimInfo.html'
            }
        ];
        
        // Date-Picker
        $scope.format = 'yyyy-dd-MM';
        $scope.today = function() {
             $scope.insurance.effectiveStartDate = new Date();
             $scope.insurance.effectiveEndDate = new Date(); 
             $scope.insurance.guarantorDOB = new Date();
             $scope.insurance.checkedOn = new Date();
        };
        $scope.clear = function() {
            $scope.insurance.effectiveStartDate = new Date();
            $scope.insurance.effectiveEndDate = new Date(); 
            $scope.insurance.guarantorDOB = new Date();
            $scope.insurance.checkedOn = new Date();
        };
        $scope.openco = function($event) {
          $event.preventDefault();
          $event.stopPropagation();
          return $scope.openedco = true;
        };
        $scope.opendobg = function($event) {
          $event.preventDefault();
          $event.stopPropagation();
          return $scope.openeddobg = true;
        };
        $scope.openesd = function($event) {
          $event.preventDefault();
          $event.stopPropagation();
          return $scope.openedesd = true;
        };
        $scope.openeed = function($event) {
          $event.preventDefault();
          $event.stopPropagation();
          return $scope.openedeed = true;
        };
        
        
        $scope.insurance =insuranceDataService.GetInsurance();
        $scope.ok = function() {
            $scope.insurance.effectiveStartDate = $filter('date')($scope.insurance.effectiveStartDate,'yyyy-MM-dd');
            $scope.insurance.effectiveEndDate = $filter('date')($scope.insurance.effectiveEndDate,'yyyy-MM-dd');
            $scope.insurance.guarantorDOB = $filter('date')($scope.insurance.guarantorDOB,'yyyy-MM-dd');
            $scope.insurance.checkedOn = $filter('date')($scope.insurance.checkedOn,'yyyy-MM-dd');
            $scope.insurance.payerId = 6;
            $modalInstance.close($scope.insurance);
        };
        $scope.cancel = function() {
            $modalInstance.dismiss("cancel");
        };
};
})();
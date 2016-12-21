(function (){
    "use strict";
angular.module('app.common')
        .factory('stateService',stateService)
        .factory('dispatchRegionService',dispatchRegionService)
        .factory('countryService',countryService)
        .factory('facilityListService',facilityListService)
        .factory('payerListService',payerListService)
        .factory('bodypartModalityListService',bodypartModalityListService)
        .factory('modalityListService',modalityListService)
        .factory('logger',logger)
        .factory('confirmService',confirmService)
        .factory('CONSTANT',CONSTANT);

stateService.$inject =['$resource','CONSTANT'];
dispatchRegionService.$inject =['$resource','CONSTANT'];
countryService.$inject =['$resource','$q','$log','CONSTANT'];
CONSTANT.$inject=[];
facilityListService.$inject=['$resource','CONSTANT'];
payerListService.$inject=['$resource','CONSTANT'];
bodypartModalityListService.$inject=['$resource','CONSTANT'];
modalityListService.$inject =['$resource','CONSTANT'];
logger.$inject =[];
confirmService.$inject =['$modal'];
function countryService($resource,$q,$log,CONSTANT){
        var countries =[];
        var countryUrl = $resource(CONSTANT.SERVICEURL + '/api/list/countries');

        return {
            countries:countries, 
            getCountries: getCountries,
            setCountries: setCountries

        };

        function getCountries(){
                return countries;
            }
        function setCountries(){
            var deferred = $q.defer();
            countryUrl.query(function (data){
                $log.debug("inside service layer cntry " + countries );
                deferred.resolve(data);
//                counties = data;
            },
            function (error){
                deferred.reject("Server responded with " + error);
                alert(error.status);
            });
            return deferred.promise;
        } 
};

function stateService($resource,CONSTANT){
    return $resource(CONSTANT.SERVICEURL + '/api/list/states/:country_id',{country_id:'@country_id'},{
        update:{
             method: 'PUT'
        }

    });

};

function dispatchRegionService($resource,CONSTANT){
        var dispatchRegions =[];
        var dispatchRegionUrl = $resource(CONSTANT.SERVICEURL + '/api/list/dispatch-regions');

        return {
            getDispatchRegions:getDispatchRegions,
            setDispatchRegions:setDispatchRegions,
            dispatchRegions :dispatchRegions
        };
        function getDispatchRegions(){
                return dispatchRegions;
            }

        function setDispatchRegions(){
            dispatchRegionUrl.query(function (data){
                dispatchRegions = data;
            },
            function (error){
                alert(error.status);
            });
        } 
};

    function CONSTANT(){
        var CONSTANT = {};
        
        CONSTANT.SERVICEURL = "/mobileris";
        
        CONSTANT.SADMIN = "ROLE_SUPERADMIN";
        CONSTANT.DCADMIN = "ROLE_DCADMIN";
        CONSTANT.DCOPERATOR = "ROLE_DCOPERATOR";
        CONSTANT.FACILITY = "ROLE_FACILITY";
        CONSTANT.TECHNOLOGIST = "ROLE_TECHNITIAN";
        CONSTANT.PATIENT = "ROLE_PATIENT";
        
        CONSTANT.ROLESFORTENANT =['ROLE_SUPERADMIN'];
        CONSTANT.ROLESFORFACILITY =['ROLE_FACILITY'];
        CONSTANT.ROLESFORDCADMIN =['ROLE_DCADMIN'];
        CONSTANT.ROLESFORDCADMINANDOPERATOR = ['ROLE_DCADMIN','ROLE_DCOPERATOR'];
        CONSTANT.ROLESFORALLEXCEPTDCADMIN =['ROLE_DCOPERATOR','ROLE_TECHNITIAN','ROLE_FACILITY','ROLE_PATIENT'];
        CONSTANT.ROLESFORDCADMINANDOPERATORTECHANICIAN = ['ROLE_DCADMIN','ROLE_DCOPERATOR','ROLE_TECHNITIAN'];
        
        CONSTANT.YESNOVALUES =[{id:true,text:'Yes'},{id:false,text:'No'}];
        
        
        CONSTANT.ROLES =['ROLE_SUPERADMIN','ROLE_DCADMIN','ROLE_DCOPERATOR','ROLE_TECHNITIAN','ROLE_PATIENT','ROLE_FACILITY'];

        CONSTANT.ROLE = [{roleType:2,roleName:'DC Admin'},{roleType:3,roleName:'DC Operator'}];
        
        //Provider constants
        CONSTANT.ORDERINGSTATUS = ['Ordering','Patient Centerderd Decision Support','Portability','Patient Safety Features','intutive Human Interface','Mangement','Billing'];
        CONSTANT.PROVIDERTYPE = ['Physician','Nurse','Refering Physician','Ordering Physican'];
        CONSTANT.NEWCORPERXROLE =['NewCrop Admin','NewCrop Nurse','NewCrop Manager','NewCrop Doctor','NewCrop Midlevel Prescriber,'];
        CONSTANT.TAXANOMYCODE=['Acupuncturist','Adult Companion','Advanced Practice Dental Therapist','Advanced Practice Midwife','Air Carrier','Allergy & Immunology','Ambulance','Anaplastologist'];

        //Payer constants
        CONSTANT.DEFAULTRATE =['Payer Allowed','Payer Pay','Patient Pay','My charges','Discounted Charges'];
        CONSTANT.IDENTIFICATION =['0B-State Licence','1A – Blue Cross Provider No','1B – Blue Sheild Provider No','1C – Medicare Provider No'];
        CONSTANT.CLEARINGHOUSE=['Navicure Inc','Pverify Inc'];
        CONSTANT.SUBMISSIONTYPE=['Individual','Batch'];
        CONSTANT.INSURANCETYPE=['Medicare','Medicaid','Long Term Policy','Auto Insurance Policy','HMO','Commercial Insurance Company','CHCS Commercial','CHCS Employer group','Individual Policy','Campus Supplement'];
        CONSTANT.CLAIMTYPE=['Liability','Liability Insurance','Managed Dental','Madicare Part A','Madicare Part B','Madicare Part C','Madicare Part D'];

        //Facility constants
        CONSTANT.POSCODE =['Unassigned','School','Homeless Shelter','Indian Health Service','Tribal 638 Free','Office','Assisted Living Facility'];
        
       return CONSTANT;
    };
    
    function confirmService($modal){
        var confirmFlag =false;
         return{
             isConfirmed:isConfirmed,
             confirmFlag:confirmFlag
         };
         function isConfirmed(){
            var modalInstance;
            confirmFlag = false;
            return confirmFlag;
         }
    };
    
    function facilityListService($resource,CONSTANT){
        return $resource(CONSTANT.SERVICEURL + '/api/list/facilities',{},{
            getFacility:{
                method:'GET',
                isArray:true
            }
        });
    };
        
    function payerListService($resource,CONSTANT){
        return $resource(CONSTANT.SERVICEURL + '/api/list/payers');
    };
    
    function bodypartModalityListService($resource,CONSTANT){
        return $resource(CONSTANT.SERVICEURL + '/api/list/modalitiesByBodyPart/:bodyPartId',{bodyPartId:'@bodyPartId'},{
            getModalitiesByBodypart:{
                method:'GET',
                isArray:true
            }
        });
    };
    
    function logger (){
        var logIt;
        toastr.options = {
            "closeButton": true,
            "positionClass": "toast-top-right"
            ,
            "timeOut": "3000"
        };
        logIt = function(message, type) {
          return toastr[type](message);
        };
        return {
            log: function(message) {
              logIt(message, 'info');
            },
            logWarning: function(message) {
              logIt(message, 'warning');
            },
            logSuccess: function(message) {
              logIt(message, 'success');
            },
            logError: function(message) {
              logIt(message, 'error');
            }
        };
    };
    
    function modalityListService($resource,CONSTANT){
        return $resource(CONSTANT.SERVICEURL + '/api/list/modalities',{},{
            getModalities:{
                method:'GET',
                isArray:true
            }
        });
    };
})();

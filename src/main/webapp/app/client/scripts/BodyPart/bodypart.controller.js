(function (){
    "use strict";

angular.module('app.bodypart')
        .controller('BodypartController',BodypartController)
        .controller('BodypartAddController',BodypartAddController)
        .controller('BodypartEditController',BodypartEditController)
        .controller('BodypartViewController',BodypartViewController);

BodypartController.$inject =['$scope','sessionService','$state','bodypartService','$filter','$log','modalityListService','logger'];
BodypartAddController.$inject =['$scope','sessionService','$state','bodypartService','modalityListService','Notification'];
BodypartEditController.$inject =['$scope','sessionService','$state','bodypartService','$stateParams','modalityListService','Notification'];
BodypartViewController.$inject =['$scope','sessionService','$state','bodypartService','$stateParams','modalityListService','Notification'];

function BodypartController($scope,sessionService,$state,bodypartService,$filter,$log,modalityListService,logger){
    $log.info("Bodypart controller initiated");
    var init;
    var isLoggedIn= sessionService.isLoggedIn();
    $scope.currentTab ="listBodyPart.html";
    $scope.readStatus = false;
    $scope.formValidStatus=false;
    $scope.updateIndex= null;
    $scope.currentTabMain = true;
    var getModalities;
    $scope.bodyparts=[];
    $scope.showSpinner = true;
    // To get list of bodyparts
    bodypartService.query().$promise.then(function (data){
        $scope.bodyparts = data;
        $scope.showSpinner = false;
        $log.debug("BodypartController: Successfully get the list of bodyparts");
        getModalities();
        init();
       
    }).catch(function (error){
        $scope.showSpinner = false;
         throw new Error(error.statusText);
         $log.error("BodypartController: " + error.statusText); 
    });
    
    //To get add bodypart page
    $scope.onClickAdd = function (){
        $log.debug("BodypartController: on-click of add bodypart");
        $scope.page ="Add";
        $scope.currentTab ="addBodyPartDetails.html";
        $scope.currentTabMain = false;
        $scope.bodypart ={};
        $scope.readStatus = false;
        $scope.formValidStatus=false;
    };
    
    // To get edit bodypart page
    $scope.onClickEdit =function (index){
        $log.debug("BodypartController: on-click of edit bodypart");
        $scope.page ="Edit";
         $scope.currentTabMain =false;
        $scope.currentTab ="addBodyPartDetails.html";
        $scope.bodypart = $scope.currentPageBodyparts[index];
        $scope.readStatus = false;
        $scope.formValidStatus=false; 
        $scope.updateIndex = index;
        
        var modality = $scope.bodypart.modality;
        $scope.bodypart.modality = [];
        angular.forEach(modality,function(value,index){
            var modality = value;
            angular.forEach($scope.modalities,function(value,index){
                var allModality = value;
                if(modality.modalityId === allModality.modalityId)
                {
                    $scope.bodypart.modality.push(modality.modalityId);      
                }
            });
                       
        });
    };
    
    // To get view bodypart page
    $scope.onClickView =function (index){
        $log.debug("BodypartController: on-click of view bodypart");
        $scope.page ="View";
        $scope.currentTabMain =false;
        $scope.currentTab ="addBodyPartDetails.html";
        $scope.bodypart = $scope.currentPageBodyparts[index];
        $scope.readStatus = true;
        $scope.formValidStatus=false;
        
    };
    
    // To get backto list bodypart page
    $scope.onClickList = function (){
        $scope.currentTab ="listBodyPart.html";
        $scope.currentTabMain =true;
    };

    // To delete bodypart 
    $scope.deleteBodyPart = function (index){
        var bodypart = $scope.bodyparts[index];  
        bodypartService.delete({bodyPartId: bodypart.bodyPartId}).$promise.then(function(){
            $log.debug("BodypartController: successfully deleted bodypart");
            $scope.bodyparts.splice(index, 1);
            logger.logSuccess('Successfully deleted ');
            init();
        }).catch(function (error){
             throw new Error(error.statusText);
             $log.error("BodypartController: " + error.statusText); 
        });
    };
    
    // To get all modalities
    var getModalities = function (){
        modalityListService.getModalities().$promise.then(function (data){
            $scope.modalities = data;
            $log.debug("BodypartController: Successfully get the list of modalities");
        }).catch(function (error){
            throw new Error(error.statusText);
            $log.error("BodypartController: " + error.statusText); 
        });
    };
    
   // To save the bodypart
    $scope.Submit = function (bodypartStatus){
        if(!bodypartStatus)
        {
            $scope.formValidStatus=true;
            $log.debug("BodypartController: form data is not valid");
            logger.logError("Please fill the required field");
        }
        else{
                $scope.formValidStatus=false;
                if($scope.page === "Add"){
                    var temp = $scope.bodypart;
                    var modality = $scope.bodypart.modality;
                    $scope.bodypart.modality = [];
                    angular.forEach(modality,function(value,index){
                        var modalitiId = value;
                        angular.forEach($scope.modalities,function(value,index){
                            var modality = value;
                            if(modalitiId === modality.modalityId)
                            {
                                $scope.bodypart.modality.push(modality);      
                            }
                        });
                       
                    });
                    bodypartService.save($scope.bodypart).$promise.then(function (data){
                        $log.debug("BodypartController: successfully added new bodypart");
                        $scope.bodyparts.push(temp);
                        logger.logSuccess('Successfully added bodypart');
                        $scope.currentTab ="listBodyPart.html";
                        $scope.currentTabMain =true;

                        init();
                    }).catch(function (error){
                         throw new Error(error.statusText);
                         $log.error("BodypartController: " + error.statusText); 
                    });
                }else if($scope.page === "Edit"){
                    var temp = $scope.bodypart;
                    var modality = $scope.bodypart.modality;
                    $scope.bodypart.modality = [];
                    angular.forEach(modality,function(value,index){
                        var modalitiId = value;
                        angular.forEach($scope.modalities,function(value,index){
                            var modality = value;
                            if(modalitiId === modality.modalityId)
                            {
                                $scope.bodypart.modality.push(modality);      
                            }
                        });
                       
                    });
                    bodypartService.update($scope.bodypart).$promise.then(function (data){
                        if($scope.updateIndex !== null)
                        {
                            $log.debug("BodypartController: successfully updated bodypart");
                            $scope.bodyparts[$scope.updateIndex] =  temp;
                            $scope.updateIndex = null;
                        }           
                        logger.logSuccess('Successfully updated bodypart ');
                        $scope.currentTab ="listBodyPart.html";
                        $scope.currentTabMain =true;
                        init();
                    }).catch(function (error){
                         throw new Error(error.statusText);
                         $log.error("BodypartController: " + error.statusText); 
                    });
                }               
            }    
    };
    
    //pagination 
    $scope.searchKeywords = '';
    $scope.filteredBodyparts = [];
    $scope.row = '';
    $scope.select = function(page) {
        var end, start;
        start = (page - 1) * $scope.numPerPage;
        end = start + $scope.numPerPage;
        return $scope.currentPageBodyparts = $scope.filteredBodyparts.slice(start, end);
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
        $scope.filteredBodyparts = $filter('filter')($scope.bodyparts, $scope.searchKeywords);
        return $scope.onFilterChange();
    };
    $scope.order = function(rowName) {
        if ($scope.row === rowName) {
          return;
        }
        $scope.row = rowName;
        $scope.filteredBodyparts = $filter('orderBy')($scope.bodyparts, rowName);
        return $scope.onOrderChange();
    };
    $scope.numPerPageOpt = [3, 5, 10, 20];
    $scope.numPerPage = $scope.numPerPageOpt[1];
    $scope.currentPage = 1;
    $scope.currentPageBodyparts = [];
    init = function() {
        $scope.search();
        return $scope.select($scope.currentPage);
    };
    return init();
};
function BodypartAddController($scope,sessionService,$state,bodypartService,modalityListService,Notification){
    $scope.page ="Add";
    $scope.readStatus = false;
    $scope.formValidStatus=false;
    
    modalityListService.getModalities(function (data){
        $scope.modalities = data;
    },function (){
        
    });
    $scope.Submit = function (bodypartStatus){
        if(!bodypartStatus)
        {
            $scope.formValidStatus=true;
            alert('You have missed somthing');
        }
        else{
                var modality = $scope.bodypart.modality;
                $scope.bodypart.modality = [];
               angular.forEach(modality,function(value,index){
                   if(value === $scope.modalities[index].modalityId)
                   {
                        $scope.bodypart.modality.push($scope.modalities[index]);      
                   }
                });
               
                 bodypartService.save($scope.bodypart,function (data){
                     Notification.success('Successfully added ');
                    $state.go('manageBodyPart');
                },function (error){
                    alert('Data is not stored');
                });
        }
        
    };
};
function BodypartEditController($scope,sessionService,$state,bodypartService,$stateParams,modalityListService,Notification){
    $scope.page ="Edit";
    $scope.readStatus = false;
    $scope.formValidStatus=false;
    $scope.bodypart =[];
    var init;
    var bodypartId = $stateParams.bodyPartId;
        bodypartService.get({bodyPartId:bodypartId},function(bodypartdata){
                $scope.bodypart =bodypartdata;
                init();
            },function (){
                alert('Somthing went wrong please try again');
            }
                    
        ); 
   
    $scope.Submit = function (bodypartStatus){
        if(!bodypartStatus)
        {
            $scope.formValidStatus=true;
            alert('You have missed somthing');
            
        }
        else{
             var modality = $scope.bodypart.modality;
             $scope.bodypart.modality = [];
            angular.forEach(modality,function(value,index){                   
                if(value === $scope.modalities[index].modalityId)
                   {
                        $scope.bodypart.modality.push($scope.modalities[index]);      
                   }   
                });
                $scope.bodypart.$update(function (data){
                    Notification.success('Successfully edited ');
                    $state.go('manageBodyPart');
                },function (error){
                    alert('Data is not stored');
                });
        }
        
    };
    
    init = function (){
         modalityListService.getModalities(function (data){
        $scope.modalities = data;
        var bodyPartModality = $scope.bodypart.modality;
        $scope.bodypart.modality =[];
        angular.forEach($scope.modalities,function(value,index){
            if(value.modalityId === $scope.modalities[index].modalityId)
            {
                   $scope.bodypart.modality.push($scope.modalities[index].modalityId);
            }
        });
    },function (){
        
    });
    };
};
function BodypartViewController($scope,sessionService,$state,bodypartService,$stateParams,modalityListService,Notification){
        $scope.page ="Edit";
        $scope.readStatus = true;
        var init;
        var bodypartId = $stateParams.bodyPartId;
        bodypartService.get({bodyPartId:bodypartId},function(bodypartdata){
                var temp = bodypartdata;
                var modalities = bodypartdata.modality;
                temp.modality =[];
                angular.forEach(modalities,function(value,index){
                   temp.modality.push(value.modalityId);      
                });
                 $scope.bodypart =temp;
            },function (){
                alert('Somthing went wrong please try again');
            }

        ); 
        modalityListService.getModalities(function (data){
            $scope.modalities = data;
            angular.forEach($scope.modalities,function(value,index){
                   $scope.bodypart.modality.push($scope.modalities[index].modalityId);
            });
        },function (){

        });
        init = function (){

        };
};

})();
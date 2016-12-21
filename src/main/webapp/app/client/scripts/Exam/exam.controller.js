(function (){
    "use strict";

angular.module('app.exam')
        .controller('ExamController',ExamController);

ExamController.$inject =['$scope','sessionService','$state','examService','$filter','bodypartModalityListService','bodypartService','logger','$log'];
function ExamController($scope,sessionService,$state,examService,$filter,bodypartModalityListService,bodypartService,logger,$log){
    $log.info("Exam controller initiated");
    var init;
    var isLoggedIn= sessionService.isLoggedIn();
    $scope.exams=[];
    $scope.readStatus = false;
    $scope.formValidStatus=false;
    $scope.currentTabMain =true;
    $scope.icdCodes =[{icdCode:0,icdCodeName:'ICD Code 1'},{icdCode:1,icdCodeName:'ICD Code 2'}];
    $scope.currentTab ="listExam.html";
    var bodyParts;
    $scope.showSpinner = true;
    // To get list of exams
    examService.query().$promise.then(function (data){
        $scope.exams = data;
        $scope.showSpinner = false;
        $log.debug("ExamController: Successfully get the list of exams");
        init();
        bodyParts();
    }).catch(function (error){
        $scope.showSpinner = false;
        throw new Error(error.statusText);
        $log.error("ExamController: " + error.statusText); 
    });

    // To get add exam
    $scope.onClickAdd = function (){
        $log.debug("ExamController: on-click of add exam");
        $scope.page ="Add";
        $scope.currentTabMain =false;
        $scope.currentTab ="addExamDetails.html";
        $scope.exam ={};
        $scope.readStatus = false;
        $scope.formValidStatus=false;
    };
    
    // To get edit exam
    $scope.onClickEdit =function (index){
        $log.debug("ExamController: on-click of edit exam");
        $scope.page ="Edit";
        $scope.currentTabMain =false;
        $scope.currentTab ="addExamDetails.html";
        $scope.exam = $scope.currentPageExams[index];
        $scope.readStatus = false;
        $scope.formValidStatus=false; 
        $scope.updateIndex = index;
        $scope.GetModalities();
    };
    
    // To get view exam
    $scope.onClickView =function (index){
        $log.debug("ExamController: on-click of view exam");
        $scope.page ="View";
        $scope.currentTabMain =false;
        $scope.currentTab ="addExamDetails.html";
        $scope.exam = $scope.currentPageExams[index];
        $scope.readStatus = true;
        $scope.formValidStatus=false;
        $scope.GetModalities();
    };
    
    // To get back to list of exam
    $scope.onClickList = function (){
        $scope.currentTab ="listExam.html";
        $scope.currentTabMain =true;

    };
    
    // To save exam
    $scope.Submit = function (examStatus){
        if(!examStatus)
        {
            $scope.formValidStatus=true;
            $log.debug("ExamController: form data is not valid");
            logger.logError("Please fill the required field");
        }
        else{
                $scope.formValidStatus=false;
                if($scope.page === "Add"){
                    examService.save($scope.exam).$promise.then(function (data){
                        $log.debug("ExamController: successfully added new exam");
                        $scope.exams.push($scope.tenant);
                        logger.logSuccess('Successfully added new exam');
                        $scope.currentTab ="listExam.html";
                        $scope.currentTabMain =true;
                        init();
                    }).catch(function (error){
                        throw new Error(error.statusText);
                        $log.error("ExamController: " + error.statusText);
                    });
                }else if($scope.page === "Edit"){
                    examService.update($scope.exam).$promise.then(function (data){
                        if($scope.updateIndex !== null)
                        {
                            $log.debug("ExamController: successfully updated exam");
                            $scope.exams[$scope.updateIndex] =  $scope.exam;
                            $scope.updateIndex = null;
                        }  
                        logger.logSuccess('Successfully updated exam ');
                        $scope.currentTab ="listExam.html";
                        $scope.currentTabMain =true;
                        init();
                    }).catch(function (error){
                            throw new Error(error.statusText);
                            $log.error("ExamController: " + error.statusText);
                    });
                }
               

        }
        
    };
    
    // To delete exam
    $scope.deleteExam = function (index){
        var exam = $scope.exams[index];  
        examService.delete({bodyPartExamId: exam.bodyPartExamId}).$promise.then(function(){
            $log.debug("ExamController: successfully deleted exam");
            $scope.exams.splice(index, 1);
            logger.logSuccess('Successfully deleted exam');
            init();
        }).catch(function (error){
            throw new Error(error.statusText);
            $log.error("ExamController: " + error.statusText);
        });
    };
    
    // To get list of modalities on selection of bodypart
    $scope.GetModalities = function (){
        bodypartModalityListService.getModalitiesByBodypart({bodyPartId:$scope.exam.bodyPartId}).$promise.then(function (data){
            $log.debug("ExamController: Successfully get the list of modalities on selection of bodypart");
            $scope.bodypartModalities = data;
        }).catch(function (error){
                throw new Error(error.statusText);
                $log.error("ExamController: " + error.statusText);
        });
    };
    
    // To get list of bodypart
    bodyParts = function (){
        if($scope.bodyparts === null)
        {
            bodypartService.query().$promise.then(function (data){
                $log.debug("ExamController: Successfully get the list of bodyparts");
                $scope.bodyparts = data; 
            }).catch(function (error){
                throw new Error(error.statusText);
                $log.error("ExamController: " + error.statusText);
            });  
        }
       
    };
    
    //pagination
    $scope.searchKeywords = '';
    $scope.filteredExams = [];
    $scope.row = '';
    $scope.select = function(page) {
        var end, start;
        start = (page - 1) * $scope.numPerPage;
        end = start + $scope.numPerPage;
        return $scope.currentPageExams = $scope.filteredExams.slice(start, end);
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
        $scope.filteredExams = $filter('filter')($scope.exams, $scope.searchKeywords);
        return $scope.onFilterChange();
    };
    $scope.order = function(rowName) {
        if ($scope.row === rowName) {
          return;
        }
        $scope.row = rowName;
        $scope.filteredExams = $filter('orderBy')($scope.exams, rowName);
        return $scope.onOrderChange();
    };
    $scope.numPerPageOpt = [3, 5, 10, 20];
    $scope.numPerPage = $scope.numPerPageOpt[1];
    $scope.currentPage = 1;
    $scope.currentPageExams = [];
    init = function() {
        $scope.search();
        return $scope.select($scope.currentPage);
    };
    return init();
};

})();
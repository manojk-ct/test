package com.zcon.mobileris.controllers;

import com.zcon.mobileris.models.dto.ExamDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.zcon.mobileris.services.interfaces.IBodyPartExamService;
import javax.validation.Valid;
import org.apache.log4j.Logger;

/**
 * @author ManojK
 */
@RestController
@RequestMapping(value = {"/bodyPartExam"})

/* This class is controller class for Body Part Exam management*/
public class BodyPartExamController {

    @Autowired
    IBodyPartExamService bodyPartExamService;

    private static final Logger log = Logger.getLogger(BodyPartExamController.class);

    /* This function is for finding all entries of Body Part Exam Entity*/
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExamDTO>> findAllExams() {
        List<ExamDTO> list = bodyPartExamService.getAllExams();
        if (list.isEmpty())
            log.debug(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /* This function is creating record for Body Part Exam entity */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExamDTO> createExam(@Valid @RequestBody ExamDTO examDTO) {
        log.debug(examDTO);
        return new ResponseEntity<>(bodyPartExamService.createExam(examDTO), HttpStatus.OK);
    }

    /* This function is finding record form Body Part Exam entity by Id */
    @RequestMapping(value = "/{bodyPartExamId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExamDTO> findExamById(@PathVariable("bodyPartExamId") int bodyPartExamId) {
        ExamDTO examDTO = bodyPartExamService.getExamById(bodyPartExamId);
        log.debug(examDTO);
        return new ResponseEntity<>(examDTO, HttpStatus.OK);
    }

    /* This function is updating record for Body Part Exam entity */
    @RequestMapping(value = "/{bodyPartExamId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExamDTO> updateExam(@PathVariable("bodyPartExamId") int bodyPartExamId,@Valid @RequestBody ExamDTO examDTO) {
        log.debug(examDTO);
        return new ResponseEntity<>(bodyPartExamService.updateExam(bodyPartExamId, examDTO), HttpStatus.OK);
    }

    /* This function is deleting record for Body Part Exam entity by Id */
    @RequestMapping(value = "/{bodyPartExamId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExamDTO> deleteExamById(@PathVariable("bodyPartExamId") int bodyPartExamId) {
        return new ResponseEntity<>(bodyPartExamService.deleteExamById(bodyPartExamId), HttpStatus.OK);
    }
}

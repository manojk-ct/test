package com.zcon.mobileris.controllers;

import com.zcon.mobileris.models.dto.PatientDTO;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.zcon.mobileris.services.interfaces.IPatientService;
import org.apache.log4j.Logger;

/**
 *
 * @author PradnyaS
 */

@RestController
@RequestMapping(value = {"patient"})

/* This class is controller class for Patient management */
public class PatientController {

    @Autowired
    IPatientService patientService;

    private static final Logger log = Logger.getLogger(PatientController.class);

    /* This function is for finding all entries of Patient Entity */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PatientDTO>> getALLPatients() {
        List<PatientDTO> list = patientService.getAllPatients();
        log.debug(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /* This function is creating record for Patient entity */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientDTO> createPatient(@Valid @RequestBody PatientDTO patient) {
        log.debug(patient);
        return new ResponseEntity<>(patientService.createPatient(patient), HttpStatus.OK);
    }

    /* This function is updating record for Patient entity with ID*/
    @RequestMapping(value = {"/{patientId}"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable("patientId") int patientId,@Valid @RequestBody PatientDTO patient) {
        log.debug(patient);
        return new ResponseEntity<>(patientService.updatePatient(patient), HttpStatus.OK);
    }

    /* This function is finding record for Patient entity with ID */
    @RequestMapping(value = {"/{patientId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientDTO> getPatientDetails(@PathVariable("patientId") int patientId) {
        PatientDTO patientDto = patientService.getPatientByPatientId(patientId);
        log.debug(patientDto);
        return new ResponseEntity<>(patientDto, HttpStatus.OK);
    }

    /* This function is deleting record for Patient entity with ID*/
    @RequestMapping(value = {"/{patientId}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deletePatient(@PathVariable("patientId") int patient_id) {
        return new ResponseEntity<>(patientService.deletePatient(patient_id), HttpStatus.OK);
    }
}

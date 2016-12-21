/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.controllers;

import com.zcon.mobileris.models.dto.PatientGridSettingDTO;
import com.zcon.mobileris.services.interfaces.IPatientGridSettingService;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PradnyaS
 */
@RestController
@RequestMapping(value = {"patientGridSetting"})
public class PatientGridSettingContoller {
    @Autowired
    IPatientGridSettingService patientGridSettingService;
    
    private static final Logger log = Logger.getLogger(RequisitionGridSettingController.class);
    
    /* This function is for finding all entries of PatientGridSetting Entity */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PatientGridSettingDTO>> getALLPatientGridSettings() {
        List<PatientGridSettingDTO> list = patientGridSettingService.getAllPatientGridSettings();
        log.debug(list);
        return new ResponseEntity<>(list , HttpStatus.OK);
    }

    /* This function is creating record for PatientGridSetting Entity */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientGridSettingDTO> createPatientGridSetting(@RequestBody PatientGridSettingDTO patientGridSetting) {
        log.debug(patientGridSetting);
        return new ResponseEntity<>(patientGridSettingService.createPatientGridSetting(patientGridSetting), HttpStatus.OK);
    }

    /* This function is updating record for PatientGridSetting Entity by ID */
    @RequestMapping(value = {"/{patientGridSettingId}"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientGridSettingDTO> updatePatientGridSetting(@PathVariable("patientGridSettingId") int patientGridSettingId, @RequestBody PatientGridSettingDTO patientGridSetting) {
        log.debug(patientGridSetting);
        return new ResponseEntity<>(patientGridSettingService.updatePatientGridSetting(patientGridSetting), HttpStatus.OK);
    }

    /* This function is finding record for PatientGridSetting Entity by ID */
    @RequestMapping(value = {"/{patientGridSettingId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientGridSettingDTO> getPatientGridSettingDetails(@PathVariable("patientGridSettingId") int patientGridSettingId) {
        PatientGridSettingDTO object = patientGridSettingService.getPatientGridSettingByPatientGridSettingId(patientGridSettingId);
        log.debug(object);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    /* This function is deleting record for PatientGridSetting Entity by ID */
    @RequestMapping(value = {"/{patientGridSettingId}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deletePatientGridSetting(@PathVariable("patientGridSettingId") int patientGridSettingId) {
        return new ResponseEntity<>(patientGridSettingService.deletePatientGridSetting(patientGridSettingId), HttpStatus.OK);
    }
}

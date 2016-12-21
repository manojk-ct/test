/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.controllers;

import com.zcon.mobileris.models.dto.RequisitionGridSettingDTO;
import com.zcon.mobileris.services.interfaces.IRequisitionGridSettingService;
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
@RequestMapping(value = {"requisitionGridSetting"})

/* This class is controller class for RequisitionGridSetting management */
public class RequisitionGridSettingController {
    @Autowired
    IRequisitionGridSettingService requisitionGridSettingService;
    
    private static final Logger log = Logger.getLogger(RequisitionGridSettingController.class);
    
    /* This function is for finding all entries of RequisitionGridSetting Entity */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RequisitionGridSettingDTO>> getALLRequisitionGridSettings() {
        List<RequisitionGridSettingDTO> list = requisitionGridSettingService.getAllRequisitionGridSettings();
        log.debug(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /* This function is creating record for RequisitionGridSetting Entity */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RequisitionGridSettingDTO> createRequisitionGridSetting( @RequestBody RequisitionGridSettingDTO requisitionGridSetting) {
        log.debug(requisitionGridSetting);
        return new ResponseEntity<>(requisitionGridSettingService.createRequisitionGridSetting(requisitionGridSetting), HttpStatus.OK);
    }

    /* This function is updating record for RequisitionGridSetting Entity by ID */
    @RequestMapping(value = {"/{requisitionGridSettingId}"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RequisitionGridSettingDTO> updateRequisitionGridSetting(@PathVariable("requisitionGridSettingId") int requisitionGridSettingId, @RequestBody RequisitionGridSettingDTO requisitionGridSetting) {
        log.debug(requisitionGridSetting);
        return new ResponseEntity<>(requisitionGridSettingService.updateRequisitionGridSetting(requisitionGridSetting), HttpStatus.OK);
    }

    /* This function is finding record for RequisitionGridSetting Entity by ID */
    @RequestMapping(value = {"/{requisitionGridSettingId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RequisitionGridSettingDTO> getRequisitionGridSettingDetails(@PathVariable("requisitionGridSettingId") int requisitionGridSettingId) {
        return new ResponseEntity<>(requisitionGridSettingService.getRequisitionGridSettingByRequisitionGridSettingId(requisitionGridSettingId), HttpStatus.OK);
    }

    /* This function is deleting record for RequisitionGridSetting Entity by ID */
    @RequestMapping(value = {"/{requisitionGridSettingId}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteRequisitionGridSetting(@PathVariable("requisitionGridSettingId") int requisitionGridSettingId) {
        log.debug(this);
        return new ResponseEntity<>(requisitionGridSettingService.deleteRequisitionGridSetting(requisitionGridSettingId), HttpStatus.OK);
    }
}

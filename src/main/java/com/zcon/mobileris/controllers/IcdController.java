/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.controllers;

import com.zcon.mobileris.models.dto.IcdCodeDTO;
import com.zcon.mobileris.services.interfaces.IIcdService;
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
import org.apache.log4j.Logger;

/**
 *
 * @author MayuriM
 */

@RestController
@RequestMapping(value = {"icd"})

/* This class is controller class for ICD code management */
public class IcdController {
    
    @Autowired
    IIcdService icdService;
    
    private static final Logger log = Logger.getLogger(IcdController.class);
    
    /* This function is for finding all entries of ICD Entity */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<IcdCodeDTO>> findAllIcdCodes() {
        List<IcdCodeDTO> list = icdService.findAllIcdCodes();
        log.debug(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
     
     /* This function is for inserting record for ICD Entity */
    @RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IcdCodeDTO> createIcd(@Valid @RequestBody IcdCodeDTO icdCode) {
        log.debug(icdCode);
        return new ResponseEntity<>(icdService.createIcd(icdCode), HttpStatus.OK);
    }

    /* This function is updating record for ICD Entity by ID */
    @RequestMapping(value = {"/{icdId}"}, method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IcdCodeDTO> updateIcdCode(@PathVariable("icdId") int icdId,@Valid @RequestBody IcdCodeDTO icdCode) {
        log.debug(icdCode);
        return new ResponseEntity<>(icdService.updateIcdCode(icdCode), HttpStatus.OK);
    }

    /* This function is finding record for ICD Entity by ID */
    @RequestMapping(value = {"/{icdId}"}, method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IcdCodeDTO> findIcdCodeByIcdCodeId(@PathVariable("icdId") int icdId) {
        IcdCodeDTO icdCode = icdService.findIcdCodeByIcdCodeId(icdId);
        log.debug(icdCode);
        return new ResponseEntity<>(icdCode, HttpStatus.OK);
    }

     /* This function is deleting record for ICD Entity by ID */
    @RequestMapping(value = {"/{icdId}"}, method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteIcdCode(@PathVariable("icdId") int icdId) {
        return new ResponseEntity<>(icdService.deleteIcdCode(icdId), HttpStatus.OK);
    }
}
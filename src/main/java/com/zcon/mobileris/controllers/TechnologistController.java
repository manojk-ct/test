/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.controllers;

import com.zcon.mobileris.models.dto.TechnologistDTO;
import com.zcon.mobileris.services.interfaces.ITechnologistService;
import java.util.List;
import javax.validation.Valid;
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
 * @author MayuriM
 */
@RestController
@RequestMapping(value = {"technologist"})
public class TechnologistController {
    
     
    @Autowired
    ITechnologistService technologistService;
    
    private static final Logger log = Logger.getLogger(TechnologistController.class);

    /* This function is for finding all entries of Technologist Entity */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TechnologistDTO>> getAllTechnologist() {
        List<TechnologistDTO> list = technologistService.getAllTechnologist();
        log.debug(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /* This function is creating record for Technologist Entity */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TechnologistDTO> createTechnologist(@Valid @RequestBody TechnologistDTO technologist) {
        log.debug(technologist);
        return new ResponseEntity<>(technologistService.createTechnologist(technologist), HttpStatus.OK);
    }

    /* This function is updating record for Technologist Entity by ID */
    @RequestMapping(value = {"/{technologistId}"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TechnologistDTO> updateTechnologist(@PathVariable("technologistId") int technologistId,@Valid @RequestBody TechnologistDTO technologist) {
        log.debug(technologist);
        return new ResponseEntity<>(technologistService.updateTechnologist(technologist), HttpStatus.OK);
    }

    /* This function is finding record for Technologist Entity by ID */
    @RequestMapping(value = {"/{technologistId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TechnologistDTO> getTechnologistDetails(@PathVariable("technologistId") int technologistId) {
        TechnologistDTO object = technologistService.getTechnologistByTechnologistId(technologistId);
        log.debug(object);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    /* This function is deleting record for Technologist Entity by ID */
    @RequestMapping(value = {"/{technologistId}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteTechnologist(@PathVariable("technologistId") int technologistId) {
        return new ResponseEntity<>(technologistService.deleteTechnologist(technologistId), HttpStatus.OK);
    }
}

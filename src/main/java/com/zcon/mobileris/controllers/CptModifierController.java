/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.controllers;

import com.zcon.mobileris.models.dto.CptModifierDTO;
import com.zcon.mobileris.services.interfaces.ICptModifierService;
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
 * @author PradnyaS
 */
@RestController
@RequestMapping(value = {"cptModifier"})
public class CptModifierController {
    
    @Autowired
    ICptModifierService cptModifierService;

    private static final Logger log = Logger.getLogger(TenantController.class);
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CptModifierDTO>> getALLCptModifier() {
        List<CptModifierDTO> list = cptModifierService.getAllCptModifier();
        log.debug(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CptModifierDTO> createCptModifier(@Valid @RequestBody CptModifierDTO cptModifier) {
        log.debug(cptModifier);
        return new ResponseEntity<>(cptModifierService.createCptModifier(cptModifier), HttpStatus.OK);
    }

    @RequestMapping(value = {"/{cptModifierId}"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CptModifierDTO> updateCptModifier(@PathVariable("cptModifierId") int cptModifierId,@Valid @RequestBody CptModifierDTO cptModifier) {
        log.debug(cptModifier);
        return new ResponseEntity<>(cptModifierService.updateCptModifier(cptModifier), HttpStatus.OK);
    }

    @RequestMapping(value = {"/{cptModifierId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CptModifierDTO> getCptModifierDetails(@PathVariable("cptModifierId") int cptModifierId) {
        CptModifierDTO cptModifierDto = cptModifierService.getCptModifierByCptModifierId(cptModifierId);
        log.debug(cptModifierDto);
        return new ResponseEntity<>(cptModifierDto, HttpStatus.OK);
    }

    @RequestMapping(value = {"/{cptModifierId}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteCptModifier(@PathVariable("cptModifierId") int cptModifierId) {
        return new ResponseEntity<>(cptModifierService.deleteCptModifier(cptModifierId), HttpStatus.OK);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.controllers;

import com.zcon.mobileris.models.dto.CptCodeDTO;
import com.zcon.mobileris.services.interfaces.ICptService;
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
@RequestMapping(value = {"cptCode"})
public class CptCodeController {
    
    @Autowired
    ICptService cptService;
    
    private static final Logger log = Logger.getLogger(CptCodeController.class);
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CptCodeDTO>> findAllCptCodes() {
        List<CptCodeDTO> list = cptService.findAllCptCodes();
        log.debug(list);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CptCodeDTO> createCpt(@Valid @RequestBody CptCodeDTO cptCodeDto) {
        log.debug(cptCodeDto);
        return new ResponseEntity<>(cptService.createCpt(cptCodeDto),HttpStatus.OK);
    }

    @RequestMapping(value = {"/{cptId}"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CptCodeDTO> updateCptCode(@PathVariable("cptId") int Cpt_Id,@Valid @RequestBody CptCodeDTO cptCodeDto) {
        log.debug(cptCodeDto);
        return new ResponseEntity<>(cptService.updateCptCode(cptCodeDto), HttpStatus.OK);
    }

    @RequestMapping(value = {"/{cptId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CptCodeDTO> findCptCodeByCptCodeId(@PathVariable("cptId") int CptId) {
       CptCodeDTO cptCodeDto = cptService.findCptCodeByCptCodeId(CptId);
       log.debug(cptCodeDto);
       return new ResponseEntity<>(cptCodeDto, HttpStatus.OK);
    }

    @RequestMapping(value = {"/{cptId}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteCptCode(@PathVariable("cptId") int CptId) {
       return new ResponseEntity<>(cptService.deleteCptCode(CptId), HttpStatus.OK);
    }
}

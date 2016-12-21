/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.controllers;

import com.zcon.mobileris.models.dto.CptChargeDTO;
import com.zcon.mobileris.services.interfaces.ICptChargeService;
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
@RequestMapping(value = {"cptCharge"})
public class CptChargeController {
    
    @Autowired
    ICptChargeService cptChargeService;

    private static final Logger log = Logger.getLogger(TenantController.class);
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CptChargeDTO>> getALLCptCharge() {
        List<CptChargeDTO> list = cptChargeService.getAllCptCharge();
        log.debug(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CptChargeDTO> createCptCharge(@Valid @RequestBody CptChargeDTO cptCharge) {
        log.debug(cptCharge);
        return new ResponseEntity<>(cptChargeService.createCptCharge(cptCharge), HttpStatus.OK);
    }

    @RequestMapping(value = {"/{cptChargeId}"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CptChargeDTO> updateCptCharge(@PathVariable("cptChargeId") int cptChargeId,@Valid @RequestBody CptChargeDTO cptCharge) {
        log.debug(cptCharge);
        return new ResponseEntity<>(cptChargeService.updateCptCharge(cptCharge), HttpStatus.OK);
    }

    @RequestMapping(value = {"/{cptChargeId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CptChargeDTO> getCptChargeDetails(@PathVariable("cptChargeId") int cptChargeId) {
        CptChargeDTO cptChargeDto = cptChargeService.getCptChargeByCptChargeId(cptChargeId);
        log.debug(cptChargeDto);
        return new ResponseEntity<>(cptChargeDto, HttpStatus.OK);
    }

    @RequestMapping(value = {"/{cptChargeId}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteCptCharge(@PathVariable("cptChargeId") int cptChargeId) {
        return new ResponseEntity<>(cptChargeService.deleteCptCharge(cptChargeId), HttpStatus.OK);
    }

}

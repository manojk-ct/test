/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.controllers;

import com.zcon.mobileris.models.dto.PayerDTO;
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
import com.zcon.mobileris.services.interfaces.IPayerService;
import org.apache.log4j.Logger;

/**
 *
 * @author PradnyaS
 */
@RestController
@RequestMapping(value = {"payer"})

/* This class is controller class for Payer management */
public class PayerController {

    @Autowired
    IPayerService payerService;

    private static final Logger log = Logger.getLogger(PayerController.class);

    /* This function is for finding all entries of Payer Entity */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PayerDTO>> getALLPayers() {
        List<PayerDTO> list = payerService.getAllPayer();
        log.debug(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /* This function is creating record for Payer entity */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayerDTO> createPayer(@Valid @RequestBody PayerDTO payer) {
        log.debug(payer);
        return new ResponseEntity<>(payerService.createPayer(payer), HttpStatus.OK);
    }

    /* This function is updating record for Payer entity with ID*/
    @RequestMapping(value = {"/{payerId}"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayerDTO> updatePayer(@PathVariable("payerId") int payerId,@Valid @RequestBody PayerDTO payer) {
        log.debug(payer);
        return new ResponseEntity<>(payerService.updatePayer(payer), HttpStatus.OK);
    }

    /* This function is finding record for Payer entity with ID*/
    @RequestMapping(value = {"/{payerId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayerDTO> getPayerDetails(@PathVariable("payerId") int payerId) {
        PayerDTO object = payerService.getPayerByPayerId(payerId);
        log.debug(object);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    /* This function is deleting record for Payer entity with ID*/
    @RequestMapping(value = {"/{payerId}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deletePayer(@PathVariable("payerId") int payer_id) {
        return new ResponseEntity<>(payerService.deletePayer(payer_id), HttpStatus.OK);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.controllers;

import com.zcon.mobileris.models.dto.ProviderDTO;
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
import com.zcon.mobileris.services.interfaces.IProviderService;
import org.apache.log4j.Logger;

/**
 *
 * @author PradnyaS
 */
@RestController
@RequestMapping(value = {"provider"})

/* This class is controller class for Provider management */
public class ProviderController {

    @Autowired
    IProviderService providerService;

    private static final Logger log = Logger.getLogger(ProviderController.class);

    /* This function is for finding all entries of Provider Entity */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProviderDTO>> getALLProviders() {
        List<ProviderDTO> list = providerService.getAllProvider();
        log.debug(list);
        return new ResponseEntity<>(list , HttpStatus.OK);
    }

    /* This function is creating record for Provider Entity */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProviderDTO> createProvider(@Valid @RequestBody ProviderDTO provider) {
        log.debug(provider);
        return new ResponseEntity<>(providerService.createProvider(provider), HttpStatus.OK);
    }

    /* This function is updating record for Provider Entity by ID */
    @RequestMapping(value = {"/{providerId}"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProviderDTO> updateProvider(@PathVariable("providerId") int providerId,@Valid @RequestBody ProviderDTO provider) {
        log.debug(provider);
        return new ResponseEntity<>(providerService.updateProvider(provider), HttpStatus.OK);
    }

    /* This function is finding record for Provider Entity by ID */
    @RequestMapping(value = {"/{providerId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProviderDTO> getProviderDetails(@PathVariable("providerId") int providerId) {
        ProviderDTO object = providerService.getProviderByProviderId(providerId);
        log.debug(object);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    /* This function is deleting record for Provider Entity by ID */
    @RequestMapping(value = {"/{providerId}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteProvider(@PathVariable("providerId") int providerId) {
        return new ResponseEntity<>(providerService.deleteProvider(providerId), HttpStatus.OK);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.controllers;

import com.zcon.mobileris.models.dto.AffiliateDTO;
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
import com.zcon.mobileris.services.interfaces.IAffiliateService;
import javax.validation.Valid;

/**
 *
 * @author MayuriM
 */
@RestController
@RequestMapping(value = {"affiliate"})
public class AffiliateController {
    
    @Autowired
    IAffiliateService affiliateService;
     
    private static final Logger log = Logger.getLogger(AffiliateController.class);

    /* This function is for finding all entries of Affiliate Entity */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AffiliateDTO>> getAllAffiliates() {
        List<AffiliateDTO> affList = affiliateService.getAllAffiliates(); 
        if (affList.isEmpty())
            log.debug(affList);
        return new ResponseEntity<>(affList, HttpStatus.OK);
    }

    /* This function is creating record for Affiliate Entity */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AffiliateDTO> createAffiliate(@Valid @RequestBody AffiliateDTO affiliates) {
        log.debug(affiliates);
        return new ResponseEntity<>(affiliateService.createAffiliate(affiliates), HttpStatus.OK);
    }

    /* This function is updating record for Affiliate Entity by ID */
    @RequestMapping(value = {"/{affialiateId}"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AffiliateDTO> updateAffiliate(@PathVariable("affialiateId") int affialiateId,@Valid @RequestBody AffiliateDTO affiliates) {
        log.debug(affiliates);
        return new ResponseEntity<>(affiliateService.updateAffiliate(affiliates), HttpStatus.OK);
    }

    /* This function is finding record for Affiliate Entity by ID */
    @RequestMapping(value = {"/{affialiateId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AffiliateDTO> getAffiliateDetails(@PathVariable("affialiateId") int affialiateId) {
        AffiliateDTO affiliate = affiliateService.getAffiliateByAffiliateId(affialiateId);
        log.debug(affiliate);
        return new ResponseEntity<>(affiliate, HttpStatus.OK);
    }

    /* This function is deleting record for Affiliate Entity by ID */
    @RequestMapping(value = {"/{affialiateId}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteAffiliate(@PathVariable("affialiateId") int affialiateId) {
        return new ResponseEntity<>(affiliateService.deleteAffiliate(affialiateId), HttpStatus.OK);
    }
            
}

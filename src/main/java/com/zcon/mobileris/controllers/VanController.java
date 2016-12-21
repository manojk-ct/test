package com.zcon.mobileris.controllers;

import com.zcon.mobileris.models.dto.VanDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zcon.mobileris.services.interfaces.IVanService;

/**
 *
 * @author PravinP
 */
@RestController
@RequestMapping(value = {"/van"})
/* This class is controller class for VANDetails management */
public class VanController {
    
    @Autowired
    IVanService vanDetailsService;
    
    private static final Logger log = Logger.getLogger(VanController.class);
    
    /* This function is for finding all entries of VANDetails Entity */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VanDTO>> findAllVANDetails(){
        List<VanDTO> vandetailsList = vanDetailsService.getAllVanDetails();
        log.debug(vandetailsList);
        return new ResponseEntity<>(vandetailsList, HttpStatus.OK);
    }
    
    /* This function is creating record for VANDetails Entity */
    @RequestMapping(value = "{/vanId}", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VanDTO> createVANDetails(@Valid @PathVariable("vanId") int vanId,@Valid @RequestBody VanDTO vandetails){
        log.debug(vandetails);
        return new ResponseEntity<>(vanDetailsService.createVANDetails(vandetails),HttpStatus.OK);
    }
    
    /* This function is finding record for VANDetail Entity by ID */
    @RequestMapping(value ="/{vanId}" ,method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VanDTO> findVANDetailsById(@PathVariable("vanId") int vanId){
        log.debug(this);
        return new ResponseEntity<>(vanDetailsService.getVANDetailsById(vanId),HttpStatus.OK);
    }
    
     /* This function is updating record for VANDetail Entity by ID */
    @RequestMapping(value = ("/{vanId}"), method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VanDTO> updateVANDetailsById(@PathVariable("vanId") int vanId,@Valid @RequestBody VanDTO vanDetails){
        log.debug(vanDetails);
        return new ResponseEntity<>(vanDetailsService.updateVANDetailsById(vanId, vanDetails),HttpStatus.OK);
    }
    
    @RequestMapping(value = ("/{vanId}"),method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VanDTO> deleteVANDetailsById(@PathVariable("vanId") int vanId){
        return new ResponseEntity<>(vanDetailsService.deleteVANDetailsById(vanId),HttpStatus.OK);
    }
}

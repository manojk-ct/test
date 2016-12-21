package com.zcon.mobileris.controllers;

import com.zcon.mobileris.models.dto.FacilitiesDTO;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.zcon.mobileris.services.interfaces.IFacilityService;
import org.apache.log4j.Logger;

/**
 *
 * @author PradnyaS
 */

@RestController
@RequestMapping(value = {"facility"})

/* This class is controller class for Facility management */
public class FacilityController{

    @Autowired
    IFacilityService facilityService;
    
    private static final Logger log = Logger.getLogger(FacilityController.class);
    
    
    /* This function is for finding all entries of Facility Entity */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FacilitiesDTO>> getALLFacilities() {
        List<FacilitiesDTO> list = facilityService.getAllFacilities();
        log.debug(list);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    /* This function is creating record for Facility entity */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FacilitiesDTO> createFacility(@Valid @RequestBody FacilitiesDTO facilityDto) {
        log.debug(facilityDto);
        return new ResponseEntity<>(facilityService.createFacility(facilityDto),HttpStatus.OK);
    }

    /* This function is updating record for Facility entity */
    @RequestMapping(value = {"/{facilityId}"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FacilitiesDTO> updateFacility(@PathVariable("facilityId") int facility_id, @RequestBody FacilitiesDTO facilityDto) {
        log.debug(facilityDto);
        return new ResponseEntity<>(facilityService.updateFacility(facilityDto), HttpStatus.OK);
    }

    /* This function is finding record form Facility entity by Id */
    @RequestMapping(value = {"/{facilityId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FacilitiesDTO> getFacilityDetails(@PathVariable("facilityId") int facilityId) {
        FacilitiesDTO facilitiesDTO = facilityService.getFacilityByFacilityId(facilityId);
        log.debug(facilitiesDTO);
        return new ResponseEntity<>(facilitiesDTO, HttpStatus.OK);
    }

    /* This function is deleting record for Facility entity by Id */
    @RequestMapping(value = {"/{facilityId}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteFacility(@PathVariable("facilityId") int facilityId) {
        return new ResponseEntity<>(facilityService.deleteFacility(facilityId), HttpStatus.OK);
    }
}

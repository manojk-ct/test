/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.controllers;

import com.zcon.mobileris.models.dto.RadiologyGroupDTO;
import com.zcon.mobileris.services.interfaces.IRadiologyGroupService;
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
@RequestMapping(value = {"radiologyGroup"})
public class RadiologyGroupController {
    
    @Autowired
    IRadiologyGroupService groupService;
    
    private static final Logger log = Logger.getLogger(RadiologyGroupController.class);
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RadiologyGroupDTO>> getALLRadiologyGroups() {
        List<RadiologyGroupDTO> list = groupService.getAllRadiologyGroup();
        log.debug(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /* This function is creating record for RadiologyGroup Entity */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RadiologyGroupDTO> createRadiologyGroup( @RequestBody RadiologyGroupDTO group) {
        log.debug(group);
        return new ResponseEntity<>(groupService.createRadiologist(group), HttpStatus.OK);
    }

    /* This function is updating record for RadiologyGroup Entity by ID */
    @RequestMapping(value = {"/{radiologyGroupId}"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RadiologyGroupDTO> updateRadiologyGroup(@PathVariable("radiologyGroupId") int radiologyGroupId, @RequestBody RadiologyGroupDTO group) {
        log.debug(group);
        return new ResponseEntity<>(groupService.updateRadiologyGroupById(group), HttpStatus.OK);
    }

    /* This function is finding record for RadiologyGroup Entity by ID */
    @RequestMapping(value = {"/{radiologyGroupId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RadiologyGroupDTO> getRadiologyGroupDetails(@PathVariable("radiologyGroupId") int radiologyGroupId) {
        RadiologyGroupDTO object = groupService.getRadiologyGroupById(radiologyGroupId);
        log.debug(object);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    /* This function is deleting record for RadiologyGroup Entity by ID */
    @RequestMapping(value = {"/{radiologyGroupId}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteRadiologyGroup(@PathVariable("radiologyGroupId") int radiologyGroupId) {
        return new ResponseEntity<>(groupService.deleteRadiologyGroupById(radiologyGroupId), HttpStatus.OK);
    }
}

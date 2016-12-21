package com.zcon.mobileris.controllers;

import com.zcon.mobileris.entity.Radiologist;
import com.zcon.mobileris.models.dto.RadiologistDTO;
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
import com.zcon.mobileris.services.interfaces.IRadiologistService;

/**
 * @author ManojK
 */
@RestController
@RequestMapping(value = {"/radiologist"})

/* This class is controller class for Radiologist management */
public class RadiologistController {

    @Autowired
    IRadiologistService radiologistService;

    private static final Logger log = Logger.getLogger(RadiologistController.class);

    /* This function is for finding all entries of Radiologist Entity */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RadiologistDTO>> findAllRadiologist() {
        List<RadiologistDTO> list = radiologistService.getAllRadiologists();
        log.debug(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /* This function is creating record for Radiologist Entity */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RadiologistDTO> createRadiologist(@Valid @RequestBody RadiologistDTO radiologist) {
        log.debug(radiologist);
        return new ResponseEntity<>(radiologistService.createRadiologist(radiologist), HttpStatus.OK);
    }

    /* This function is finding record for Radiologist Entity by ID */
    @RequestMapping(value = {"/{radiologistId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RadiologistDTO> findRadiologistById(@PathVariable("radiologistId") int radiologistId) {
        RadiologistDTO object = radiologistService.getRadiologistById(radiologistId);
        log.debug(object);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    /* This function is updating record for Radiologist Entity by ID */
    @RequestMapping(value = {"/{radiologistId}"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RadiologistDTO> updateRadiologistById(@PathVariable("radiologistId") int radiologistId,@Valid @RequestBody RadiologistDTO radiologist) {
        log.debug(radiologist);
        return new ResponseEntity<>(radiologistService.updateRadiologistById(radiologistId, radiologist), HttpStatus.OK);
    }

    /* This function is deleting record for Radiologist Entity by ID */
    @RequestMapping(value = {"/{radiologistId}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RadiologistDTO> deleteRadiologistById(@PathVariable("radiologistId") int radiologistId) {
        return new ResponseEntity<>(radiologistService.deleteRadiologistById(radiologistId), HttpStatus.OK);
    }
}

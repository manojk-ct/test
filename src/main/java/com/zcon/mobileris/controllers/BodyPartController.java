package com.zcon.mobileris.controllers;

import com.zcon.mobileris.entity.BodyPart;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.zcon.mobileris.services.interfaces.IBodyPartService;
import javax.validation.Valid;
import org.apache.log4j.Logger;

/**
 * @author ManojK
 */

@RestController
@RequestMapping(value = {"/bodypart"})

/* This class is controller class for Body Part management*/
public class BodyPartController {

    @Autowired
    IBodyPartService bodyPartService;

    private static final Logger log = Logger.getLogger(BodyPartController.class);

    /* This function is for finding all entries of Body Part Entity*/
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BodyPart>> findAllBodyParts() {
        List<BodyPart> bodypartList = bodyPartService.getAllBodyParts(); 
        if (bodypartList.isEmpty())
            log.debug(bodypartList);
        return new ResponseEntity<>(bodyPartService.getAllBodyParts(), HttpStatus.OK);
    }

    /* This function is creating record for Body Part entity */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BodyPart> createBodyPart(@Valid @RequestBody BodyPart bodyPart) {
        log.debug(bodyPart);
        return new ResponseEntity<>(bodyPartService.createBodyPart(bodyPart), HttpStatus.OK);
    }

    /* This function is updating record for Body Part entity */
    @RequestMapping(value = {"/{bodyPartId}"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BodyPart> updateBodyPart(@PathVariable("bodyPartId") int bodyPartId,@Valid @RequestBody BodyPart bodyPart) {
        log.debug(bodyPart);
        return new ResponseEntity<>(bodyPartService.updateBodyPart(bodyPartId, bodyPart), HttpStatus.OK);
    }

    /* This function is finding record form Body Part entity by id */
    @RequestMapping(value = {"/{bodyPartId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BodyPart> getBodyPartById(@PathVariable("bodyPartId") int bodyPartId) {
        BodyPart bodyPart = bodyPartService.getBodyPartById(bodyPartId);
        log.debug(bodyPart);
        return new ResponseEntity<>(bodyPart, HttpStatus.OK);
    }

    /* This function is deleting record for Body Part entity by Id */
    @RequestMapping(value = {"/{bodyPartId}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BodyPart> deleteBodyPartById(@PathVariable("bodyPartId") int bodyPartId) {
        return new ResponseEntity<>(bodyPartService.deleteBodyPartById(bodyPartId), HttpStatus.OK);
    }
}

package com.zcon.mobileris.controllers;

import com.zcon.mobileris.entity.BodyPartExam;
import com.zcon.mobileris.entity.DispatchRegions;
import com.zcon.mobileris.entity.Country;//States;
import com.zcon.mobileris.entity.Facilities;
import com.zcon.mobileris.entity.IcdCode;
import com.zcon.mobileris.entity.Modality;
import com.zcon.mobileris.entity.Payer;
import com.zcon.mobileris.entity.RadiologyGroup;
import com.zcon.mobileris.entity.States;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zcon.mobileris.services.interfaces.IListService;

/**
 * @author ManojK
 */
@RestController
@RequestMapping(value = {"/list"}, method = RequestMethod.GET)

/* This class is ListController class for multiple entities
 * i.e. instead of accessing all fields of the object if controller wants the limited fields then that list is managed by this class
 */
public class ListController {

    @Autowired
    IListService listService;

    private static final Logger log = Logger.getLogger(ListController.class);

    /* This function is for listing countries */
    @RequestMapping(value = {"/countries"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Country>> getAllCountries() {
        List<Country> countries = listService.getAllCountries();
        log.debug(countries);
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    /* This function is for listing states */
    @RequestMapping(value = {"/states/{country_id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<States>> getAllStates(@PathVariable("country_id") int country_id) {
        List<States> states = listService.getAllStates(country_id);
        log.debug(states);
        return new ResponseEntity<>(states, HttpStatus.OK);
    }

    /* This function is for listing dispatch regions */
    @RequestMapping(value = {"/dispatch-regions"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DispatchRegions>> getAllDispatchRegions() {
        List<DispatchRegions> dispatch_regions = listService.getAllDispatchRegions();
        log.debug(dispatch_regions);
        return new ResponseEntity<>(dispatch_regions, HttpStatus.OK);
    }

    /* This function is for listing radiologist group */
    @RequestMapping(value = {"/ragiology-groups"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RadiologyGroup>> getAllRadiologyGroups() {
        List<RadiologyGroup> radiologyGroup = listService.getAllRadiologyGroups();
        log.debug(radiologyGroup);
        return new ResponseEntity<>(radiologyGroup, HttpStatus.OK);
    }

    /* This function is for listing modalities */
    @RequestMapping(value = {"/modalities"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Modality>> getAllModalities() {
        List<Modality> modality = listService.getAllModalities();
        log.debug(modality);
        return new ResponseEntity<>(modality, HttpStatus.OK);
    }

    /* This function is for listing modalities which are mapped with body parts */
    @RequestMapping(value = {"/modalitiesByBodyPart/{bodyPartId}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Modality>> getModalitiesByBodyPart(@PathVariable("bodyPartId") int bodyPartId) {
        Set<Modality> modality = listService.getModalitiesByBodyPart(bodyPartId);
        log.debug(modality);
        return new ResponseEntity<>(modality, HttpStatus.OK);
    }

    /* This function is for listing facilities */
    @RequestMapping(value = {"/facilities"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Facilities>> getAllFacilities() {
        List<Facilities> facilityList = listService.getAllFacilities();
        log.debug(facilityList);
        return new ResponseEntity<>(facilityList, HttpStatus.OK);
    }

    /* This function is for listing payers */
    @RequestMapping(value = {"/payers"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Payer>> getAllPayers() {
        List<Payer> payer = listService.getAllPayers();
         log.debug(payer);
        return new ResponseEntity<>(payer, HttpStatus.OK);
    }

    /* This function is for listing IcdCode */
    @RequestMapping(value = {"/icdCodes"}, params = {"searchString"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<IcdCode>> getICDBySearchString(@RequestParam(value = "searchString") String searchString) {
        List<IcdCode> list = listService.getICDBySearchString(searchString);
        log.debug(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @RequestMapping(value = {"/exams"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BodyPartExam>> getAllExams() {
        List<BodyPartExam> exam = listService.getAllExams();
         log.debug(exam);
        return new ResponseEntity<>(exam, HttpStatus.OK);
    }

}

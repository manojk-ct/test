package com.zcon.mobileris.controllers;

import com.zcon.mobileris.models.dto.TenantDTO;
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
import com.zcon.mobileris.services.interfaces.ITenantService;
import javax.validation.Valid;
import org.apache.log4j.Logger;

/**
 *
 * @author PradnyaS
 */
@RestController
@RequestMapping(value = {"tenant"})

/* This class is controller class for Tenant management */
public class TenantController {

    @Autowired
    ITenantService tenantService;

    private static final Logger log = Logger.getLogger(TenantController.class);

    /* This function is for finding all entries of Tenant Entity */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TenantDTO>> getALLTenants() {
        List<TenantDTO> list = tenantService.getAllTenants();
        log.debug(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /* This function is creating record for Tenant Entity */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TenantDTO> createTenant(@Valid @RequestBody TenantDTO tenant) {
        log.debug(tenant);
        return new ResponseEntity<>(tenantService.createTenant(tenant), HttpStatus.OK);
    }

    /* This function is updating record for Tenant Entity by ID */
    @RequestMapping(value = {"/{tenantId}"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TenantDTO> updateTenant(@PathVariable("tenantId") int tenantId,@Valid @RequestBody TenantDTO tenant) {
        log.debug(tenant);
        return new ResponseEntity<>(tenantService.updateTenant(tenant), HttpStatus.OK);
    }

    /* This function is finding record for Tenant Entity by ID */
    @RequestMapping(value = {"/{tenantId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TenantDTO> getTenantDetails(@PathVariable("tenantId") int tenantId) {
        TenantDTO object = tenantService.getTenantByTenantId(tenantId);
        log.debug(object);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    /* This function is deleting record for Tenant Entity by ID */
    @RequestMapping(value = {"/{tenantId}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteTenant(@PathVariable("tenantId") int tenantId) {
        return new ResponseEntity<>(tenantService.deleteTenant(tenantId), HttpStatus.OK);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.controllers;

import com.zcon.mobileris.models.dto.UserManagementDTO;
import com.zcon.mobileris.models.dto.validator.FileValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.zcon.mobileris.services.interfaces.IUserManagementService;
import java.io.IOException;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @author PradnyaS
 */

@RestController
@RequestMapping(value = {"userManagement"})

/* This class is controller class for User management */

public class UserManagementController {
    
    @Autowired
    IUserManagementService userManagementService;
    
    @Autowired
    FileValidator fileVaildator;
    
    @InitBinder("userManagementDTO")
    protected void initBinderUserManagementDTO(WebDataBinder binder)
    {
      binder.setValidator(fileVaildator);
    }    
    
    private static final Logger log = Logger.getLogger(UserManagementController.class);
    
    /* This function is for finding all entries of UserManagement Entity */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserManagementDTO>> getALLUserManagement() {
        List<UserManagementDTO> list = userManagementService.getAllUserManagement();
        log.debug(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /* This function is creating record for UserManagement Entity */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserManagementDTO> createUserManagement(UserManagementDTO userManagement,BindingResult result) throws IOException {
        log.debug(userManagement);
        return new ResponseEntity<>(userManagementService.createUserManagement(userManagement,result), HttpStatus.OK);
    }

    /* This function is updating record for UserManagement Entity by ID */
    @RequestMapping(value = {"/{userId}"}, method = RequestMethod.POST)
    public ResponseEntity<UserManagementDTO> updateUserManagement(@PathVariable("userId") int userId, UserManagementDTO userManagement,BindingResult result) {
        log.debug(userManagement);
        return new ResponseEntity<>(userManagementService.updateUserManagement(userManagement,result), HttpStatus.OK);
    }

    /* This function is finding record for UserManagement Entity by ID */
    @RequestMapping(value = {"/{userId}"}, method = RequestMethod.GET)
    public ResponseEntity<UserManagementDTO> getUserManagementDetails(@PathVariable("userId") int userId) {
        UserManagementDTO object = userManagementService.getUserManagementByUserManagementId(userId);
        log.debug(object);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    /* This function is deleting record for UserManagement Entity by ID */
    @RequestMapping(value = {"/{userId}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteUserManagement(@PathVariable("userId") int userId) {
        return new ResponseEntity<>(userManagementService.deleteUserManagement(userId), HttpStatus.OK);
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.models.dto.validator;

import com.zcon.mobileris.models.dto.UserManagementDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Manoj
 */
@Component
public class FileValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return UserManagementDTO.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        UserManagementDTO userManagementDTO = (UserManagementDTO)obj;
        if(userManagementDTO.getFile().getSize() == 0)
        {
            errors.rejectValue("file", "missing.file");
        }
    }
    
}

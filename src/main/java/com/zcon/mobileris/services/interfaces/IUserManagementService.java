/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.interfaces;

import com.zcon.mobileris.exceptions.FileUploadException;
import com.zcon.mobileris.models.dto.UserManagementDTO;
import java.io.IOException;
import java.util.List;
import org.springframework.validation.BindingResult;

/**
 *
 * @author PradnyaS
 */
public interface IUserManagementService {
    public List<UserManagementDTO> getAllUserManagement();

    public UserManagementDTO createUserManagement(UserManagementDTO user,BindingResult result) throws IOException,FileUploadException;

    public UserManagementDTO getUserManagementByUserManagementId(int userId);

    public UserManagementDTO updateUserManagement(UserManagementDTO user,BindingResult result);

    public boolean deleteUserManagement(int userId); 
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.UserManagement;
import java.util.List;

/**
 *
 * @author PradnyaS
 */
public interface IUserManagementRepository {
    public List<UserManagement> getAllUserManagement();

    public UserManagement createUserManagement(UserManagement user);

    public UserManagement getUserManagementByUserManagementId(int userId);

    public UserManagement updateUserManagement(UserManagement user);

    public boolean deleteUserManagement(int userId); 
    
}

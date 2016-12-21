/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.interfaces;

import com.zcon.mobileris.entity.User;

/**
 *
 * @author PradnyaS
 */
public interface UserService {
    
    User loadUserByUsername(String username);
}

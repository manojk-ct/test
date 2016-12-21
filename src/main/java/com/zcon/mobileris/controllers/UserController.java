package com.zcon.mobileris.controllers;

import com.zcon.mobileris.repositories.interfaces.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

        private static final Logger log = Logger.getLogger(UserController.class);
        
        @RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHome() {
		return "home page"; //anonymous user support
	}
 
        @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public String getAdminHome() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                log.debug(authentication);
                String name = authentication.getName();
                return name;
                
	}
        
}

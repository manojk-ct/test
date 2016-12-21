package com.zcon.mobileris.repositories.interfaces;

import com.zcon.mobileris.entity.User;

public interface UserRepository {

	User findByUsername(String username);
	
}


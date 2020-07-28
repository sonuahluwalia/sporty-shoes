package com.sporty.shoes.service.iface;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sporty.shoes.entity.User;

public interface UserService {

	String changePassword(String password);

	Page<User> getUsers(Pageable pageable);
	
	User findUserByName(String name);

}
package com.sporty.shoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sporty.shoes.entity.User;
import com.sporty.shoes.repositry.UserRepository;
import com.sporty.shoes.security.MyUserDetails;
import com.sporty.shoes.security.SecuredPasswordGenerator;


@Controller
public class AdminController {

	@Autowired
	UserRepository userRepositry;
	
	@GetMapping("/")
	public String loginSuccessHandler() {
		System.out.println("reached login success handler");
		return "index";
	}
	
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestParam String password) {
		System.out.println("reached changed password");
		System.out.println(password);
		MyUserDetails securedUser = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(securedUser.getUsername());
		User user = userRepositry.getUserByUsername(securedUser.getUsername());
		user.setPassword(SecuredPasswordGenerator.securedPassword(password));
		userRepositry.save(user);
		System.out.println(user.getUsername() + " password changed successfully");
		return "index";
	}

}

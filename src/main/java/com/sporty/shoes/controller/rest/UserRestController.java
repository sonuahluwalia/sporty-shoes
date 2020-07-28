package com.sporty.shoes.controller.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sporty.shoes.entity.User;
import com.sporty.shoes.service.iface.UserService;
import com.sporty.shoes.util.Constants;

@RestController
@RequestMapping("/users")
@SuppressWarnings(value = "unchecked")
public class UserRestController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/list")
	<T> ResponseEntity<T> getUsersPage(@RequestParam int page, @RequestParam int size) {
		if (page < 0 || size < 0) {
			return new ResponseEntity<T>((T) Constants.invalidPageAndSize, HttpStatus.BAD_REQUEST);
		} else {
			PageRequest pageRequest = PageRequest.of(page - 1, size);
			return new ResponseEntity<T>((T) userService.getUsers(pageRequest), HttpStatus.OK);

		}
	}

	@PostMapping(path = "/findUserByName")
	public <T> ResponseEntity<T> findUserByName(String name) {

		User user = userService.findUserByName(name);
		if (user == null) {
			return new ResponseEntity<T>((T) Constants.userNotFound, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<T>((T) user, HttpStatus.OK);
		}
	}

}

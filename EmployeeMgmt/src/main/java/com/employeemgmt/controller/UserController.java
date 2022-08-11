package com.employeemgmt.controller;

import com.employeemgmt.model.User;
import com.employeemgmt.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/user/add")
	public void saveUser(@RequestBody User user) {
		userService.save(user);
	}
}

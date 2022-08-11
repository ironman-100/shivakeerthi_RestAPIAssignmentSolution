package com.employeemgmt.controller;

import com.employeemgmt.model.Role;
import com.employeemgmt.service.RoleService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

	private RoleService roleService;

	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	@PostMapping("/role/add")
	public void saveRole(@RequestBody Role role) {
		roleService.save(role);
	}
}

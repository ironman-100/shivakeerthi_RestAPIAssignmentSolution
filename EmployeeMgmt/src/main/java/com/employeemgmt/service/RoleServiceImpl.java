package com.employeemgmt.service;

import java.util.List;
import java.util.Optional;

import com.employeemgmt.dao.RoleRepository;
import com.employeemgmt.model.Role;

public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;

	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Role> findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Role theRole) {
		roleRepository.save(theRole);

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Role> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

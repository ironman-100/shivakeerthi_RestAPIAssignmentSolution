package com.employeemgmt.service;

import java.util.List;
import java.util.Optional;

import com.employeemgmt.dao.UserRepository;
import com.employeemgmt.model.User;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findById(long theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User theUser) {
		this.userRepository = userRepository;

	}

	@Override
	public void deleteById(long theId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<User> findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}

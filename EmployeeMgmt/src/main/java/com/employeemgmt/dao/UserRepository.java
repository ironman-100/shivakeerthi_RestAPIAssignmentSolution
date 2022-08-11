package com.employeemgmt.dao;

import com.employeemgmt.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User getByUsername(String username);

}

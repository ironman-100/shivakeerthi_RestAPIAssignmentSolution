package com.employeemgmt.dao;

import java.util.List;

import com.employeemgmt.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> searchByFirstNameEmployees(String firstName);

	List<Employee> sortByFirstNameAscEmployees();
}

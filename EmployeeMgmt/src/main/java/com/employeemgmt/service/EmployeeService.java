package com.employeemgmt.service;

import java.util.List;
import java.util.Optional;

import com.employeemgmt.model.Employee;

public interface EmployeeService {

	public List<Employee> findEmployees();

	public Optional<Employee> findByEmployeeId(int employeeId);

	public void saveEmployee(Employee employee);

	public void deleteEmployeeById(int emplyeeId);

	public List<Employee> searchByFirstNameEmployees(String firstName);

	public List<Employee> sortByFirstNameAscEmployees();

}

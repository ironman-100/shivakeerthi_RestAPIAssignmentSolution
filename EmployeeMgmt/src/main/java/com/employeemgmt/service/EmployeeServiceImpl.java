package com.employeemgmt.service;

import java.util.List;
import java.util.Optional;

import com.employeemgmt.dao.EmployeeRepository;
import com.employeemgmt.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findByEmployeeId(int employeeId) {
		return employeeRepository.findById(employeeId);
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public void deleteEmployeeById(int emplyeeId) {
		employeeRepository.delete(employeeRepository.getById(emplyeeId));

	}

	@Override
	public List<Employee> searchByFirstNameEmployees(String firstName) {
		return employeeRepository.searchByFirstNameEmployees(firstName);
	}

	@Override
	public List<Employee> sortByFirstNameAscEmployees() {
		return employeeRepository.sortByFirstNameAscEmployees();
	}

}

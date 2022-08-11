package com.employeemgmt.controller;

import java.util.List;
import java.util.Optional;

import com.employeemgmt.model.Employee;
import com.employeemgmt.service.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("employee/list")
	public List<Employee> getAllEmployees() {
		return employeeService.findEmployees();
	}

	@GetMapping("/employee/{employeeId}")
	public Optional<Employee> getEmployeeById(@PathVariable int employeeId) {
		return employeeService.findByEmployeeId(employeeId);
	}

	@PostMapping("/employee/add")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
	}

	@DeleteMapping("/employee/delete/{employeeId}")
	public void deleteEmployee(@PathVariable int employeeId) {
		employeeService.deleteEmployeeById(employeeId);
	}

	@GetMapping("/employee/search/{firstName}")
	public List<Employee> getEmployeeByFirstName(@PathVariable String firstName) {
		return employeeService.searchByFirstNameEmployees(firstName);
	}

	@GetMapping("/employees/sort")
	public List<Employee> sortByFirstName() {
		return employeeService.sortByFirstNameAscEmployees();
	}
}

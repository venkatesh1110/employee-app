package com.sample.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.employee.dao.EmployeeDAO;
import com.sample.employee.entity.Employee;

@RestController
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeDAO employeeService;

	@GetMapping("/getEmployeesByName/{employeeName}")
	public List<Employee> getEmployeesByName(@PathVariable(name = "employeeName") String name) {
		List<Employee> employees = (List<Employee>) employeeService.findByName(name);
		logger.info("Employee details by Name returned Successfully");
		return employees;
	}

	@GetMapping("/getEmployees")
	public List<Employee> getEmployees() {
		List<Employee> employees = (List<Employee>) employeeService.findAll();
		logger.info("Employee details returned Successfully");
		return employees;
	}

	@GetMapping("/getEmployeesByDepartment/{dept1}/{dept2}")
	public List<Employee> getEmployeesByDepartment(@PathVariable(name = "dept1") String dept1,
			@PathVariable(name = "dept2") String dept2) {
		List<Employee> employees = (List<Employee>) employeeService.findByDept(dept1, dept2);
		logger.info("Employee details by Departments returned Successfully");
		return employees;
	}

	@PostMapping(path = "/saveEmployee")
	public void saveEmployee(Employee employee) {
		employeeService.save(employee);
		logger.info("Employee Saved Successfully");
	}

}

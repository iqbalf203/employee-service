package com.ibm.springboot.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.demo.model.Employee;
import com.ibm.springboot.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/all")
	public List<Employee> allEmployees(){
		
		return service.getAllEmployees();
		
	}
	
	
	@GetMapping("/id/{empId}")
	public Employee findById(@PathVariable int empId) {
		
		return service.getEmployeeById(empId);
		
	}
	
	@GetMapping("delete/{empId}")
	public Employee deleteById(@PathVariable int empId) {
		
		return service.deleteEmployee(empId);
	}
	
	@GetMapping("update/{empId}")
	public Employee update(@PathVariable int empId) {
		
		Employee temp = service.getEmployeeById(empId);
		return service.updateEmployee(temp);
		
	}
	
	@GetMapping("/create/{empId}/{name}/{salary}")
	public Employee create(
			@PathVariable int empId,
			@PathVariable String name,
			@PathVariable double salary
			) {
		return service.createEmployee(empId,name,salary);
		
	}

}

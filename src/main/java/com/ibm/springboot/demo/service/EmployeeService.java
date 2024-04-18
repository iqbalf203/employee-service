package com.ibm.springboot.demo.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.ibm.springboot.demo.model.Employee;

public interface EmployeeService {
	
	public abstract Employee getEmployeeById(String employeeId);

	public abstract List<Employee> getAllEmployees();

//	public abstract Employee updateEmployee(Employee employee);

	public abstract String deleteEmployee(String employeeId);
	
	public abstract String createEmployee(Employee employee);
	
	public abstract List<Employee> findByName(String name);

}

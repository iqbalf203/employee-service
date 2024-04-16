package com.ibm.springboot.demo.service;

import java.util.List;

import com.ibm.springboot.demo.model.Employee;

public interface EmployeeService {
	
	public abstract Employee getEmployeeById(Integer employeeId);

	public abstract List<Employee> getAllEmployees();

	public abstract Employee updateEmployee(Employee employee);

	public abstract Employee deleteEmployee(Integer employeeId);
	
	public abstract Employee createEmployee(int empId,String name,double salary);

}

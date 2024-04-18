package com.ibm.springboot.demo.service;

import java.util.ArrayList;		
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.demo.model.Employee;
import com.ibm.springboot.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private final Logger LOG =LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmployeeRepository repository;

	List<Employee> l = new ArrayList<>();

	Employee found;


	@Override
	public Employee getEmployeeById(String employeeId) {
		Employee temp = repository.findById(employeeId).get();
		return temp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		LOG.info(l.toString());
		
		return repository.findAll();		
	}

//	@Override
//	public Employee updateEmployee(Employee employee) {
//		LOG.info(employee.toString());
//		Employee temp = getEmployeeById(employee.getEmpId());
//		temp.setEmpName("Zack");
//		l.remove(temp);
//		l.add(temp);
//		return temp;
//	}

	@Override
	public String deleteEmployee(String employeeId) {
		
		repository.deleteById(employeeId);
		return "Employee removed.";
		
	}

	@Override
	public List<Employee> findByName(String name) {
		
		List<Employee> temp = repository.findByName(name);
		if (temp.isEmpty()) {
			
			return null;
			
		}
		else {
			return temp;
		}
	}

	@Override
	public String createEmployee(Employee employee) {
		repository.save(employee);
		return "Success";
	}



}

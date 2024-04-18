package com.ibm.springboot.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.springboot.demo.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
	
		List<Employee> findByName(String name);
	
	

}

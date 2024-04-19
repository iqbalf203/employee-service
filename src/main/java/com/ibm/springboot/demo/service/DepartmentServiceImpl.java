package com.ibm.springboot.demo.service;

import java.util.List;	
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.demo.exception.DepartmentNotFoundException;
import com.ibm.springboot.demo.model.Department;
import com.ibm.springboot.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private final Logger LOG =LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DepartmentRepository repository;

	@Override
	public List<Department> getAllDepartments() {
		
		List<Department> dpList = repository.findAll();
		if (dpList.isEmpty()) {
			String errorMessage = "No Department exist!";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundException(errorMessage);
		}
		LOG.info("Get All Method Invoked");
		return dpList;
	}

	@Override
	public Department getDepartmentById(String departmentId) {
		
		Optional<Department> optDepartment = repository.findById(departmentId);
		
		if (optDepartment.isEmpty()) {
			
			String errorMessage = "Department id: "+departmentId+" not found.";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundException(errorMessage);
			
		}
		else {
			
			return optDepartment.get();
			
		}
	}

	@Override
	public Department addDepartment(Department department) {
		if (repository.findById(department.getId())!=null) {
			String errorMessage = "Department already exist";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundException(errorMessage);
		}
			
		return repository.save(department);
	}

	@Override
	public Department deleteDepartment(String departmentId) {
		
		Department tempDepartment = getDepartmentById(departmentId);
		
		repository.deleteById(departmentId);
		
		return tempDepartment;
		
	}

	@Override
	public Department updateDepartment(Department department, String departmentId) {
		
		Department tempDepartment = getDepartmentById(departmentId);
		
		if(department.getDepartmentName()!=null) {
			
			tempDepartment.setDepartmentName(department.getDepartmentName());
			
		}
		if(department.getLocation()!=null) {
			
			tempDepartment.setLocation(department.getLocation());
			
		}
		if(department.getManagerId()!=null) {
			
			tempDepartment.setManagerId(department.getManagerId());
			
		}
		
		return repository.save(tempDepartment);
	}

	@Override
	public List<Department> getByDepartmentName(String departmentName) {
		
		List<Department> dpList = repository.findByDepartmentName(departmentName);
		if (dpList.isEmpty()) {
			String errorMessage = "No Department named" + departmentName + " found!";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundException(errorMessage);
		}
		return dpList;
	}

	

}

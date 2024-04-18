package com.ibm.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.demo.exception.DepartmentNotFoundException;
import com.ibm.springboot.demo.model.Department;
import com.ibm.springboot.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository repository;

	@Override
	public List<Department> getAllDepartments() {
		
		return repository.findAll();
	}

	@Override
	public Department getDepartmentById(String departmentId) {
		
		try {
		Optional<Department> department = repository.findById(departmentId);
		return department.get();
		}
		catch(Exception e) {
			throw new DepartmentNotFoundException(e);
		}
	}

	@Override
	public Department addDepartment(Department department) {
			
		return repository.save(department);
	}

	@Override
	public void deleteDepartment(String departmentId) {
		
		repository.deleteById(departmentId);
		
	}

	@Override
	public Department updateDepartment(Department department, String id) {
		
		Department tempDepartment = getDepartmentById(id);
		
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

	

}

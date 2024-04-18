package com.ibm.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.demo.exception.DepartmentNotFoundException;
import com.ibm.springboot.demo.model.Department;
import com.ibm.springboot.demo.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService service;
	
	
	@GetMapping("/get-all")
	public ResponseEntity<List<Department>> findAllDepartments(){
		
		List<Department> department = service.getAllDepartments();
		
		return ResponseEntity.ok(department);
		
	}
	
	@GetMapping("/id-{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable(name = "id") String id){
		
		Department department = service.getDepartmentById(id);
		
		return ResponseEntity.ok(department);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<Department> addDepartment(@RequestBody Department tempDepartment){
		
		Department department = service.addDepartment(tempDepartment);
		
		return ResponseEntity.ok(department);
		
	}
	
	@PutMapping("/update/id-{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable(name = "id") String id,@RequestBody Department tempDepartment){
		
		Department department = service.updateDepartment(tempDepartment, id);
		return ResponseEntity.ok(department);
	}
	
	@DeleteMapping("/delete/id-{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") String id) {
		
		service.deleteDepartment(id);
		
		return ResponseEntity.ok("Department Deleted");
	}
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	  public ResponseEntity<?> handleException(DepartmentNotFoundException e) {
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	    		
	  }
}
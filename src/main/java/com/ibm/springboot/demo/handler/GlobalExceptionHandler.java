package com.ibm.springboot.demo.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.springboot.demo.exception.DepartmentNotFoundException;
import com.ibm.springboot.demo.model.Department;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	
	  public ResponseEntity<Department> handleDepartmentNotFoundException(DepartmentNotFoundException e) 
	{
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", e.getMessage());
		HttpStatus status = HttpStatus.NOT_FOUND;
		ResponseEntity<Department> response = new ResponseEntity<Department>(null, headers, status);
		return response;
	    		
	  }
	

}

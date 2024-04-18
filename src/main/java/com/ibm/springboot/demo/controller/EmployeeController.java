package com.ibm.springboot.demo.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<Employee> findById(@PathVariable(name="empId") String empId) {
		
		Employee temp = service.getEmployeeById(empId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Successful");
		ResponseEntity<Employee> response = new ResponseEntity<>(temp,headers,status);
		return response;
		
		
	}
	
	@GetMapping("delete/{empId}")
	public String deleteById(@PathVariable(name="empId") String empId) {
		
		return service.deleteEmployee(empId);
	}
	
//	@GetMapping("update/{empId}")
//	public Employee update(@PathVariable(name="empId") int empId) {
//		
//		Employee temp = service.getEmployeeById(empId);
//		return service.updateEmployee(temp);
//		
//	}
	
//	@GetMapping("/create/{empId}/{name}/{salary}")
//	public Employee create(
//			@PathVariable(name="empId") int empId,
//			@PathVariable(name="name") String name,
//			@PathVariable(name="salary") double salary
//			) {
//		return service.createEmployee(empId,name,salary);
//		
//	}
	
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<Employee>> findByName(@PathVariable(name="name") String name) throws Exception {
		
		List<Employee> temp = service.findByName(name);
		
			return ResponseEntity.ok(temp);

}
	@PostMapping("/create")
	public  String createEmployee(@RequestBody Employee employee) {
		
		return service.createEmployee(employee);
		
	}

}
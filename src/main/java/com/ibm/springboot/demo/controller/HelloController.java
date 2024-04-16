package com.ibm.springboot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	
	@GetMapping("/get-data")
	public String hi() {
		
		return "HelloController World!";
		
	}
	
	@GetMapping("/hi2")
	public String hi2(String[] args) {
		
		return "Hi to You all!!";
		
		
	}
	
}

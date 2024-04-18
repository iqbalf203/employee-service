package com.ibm.springboot.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DepartmentServiceAspect {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.ibm.springboot.demo.service.*.*(..))")
	public void serviceMethodBefore() {
		System.out.println("It is working");
		LOG.info("A method from EmployeeServiceImpl was invoking.");
	}
	
	@After("execution(* com.ibm.springboot.demo.service.*.*(..))")
	public void serviceMethodAfter() {
		System.out.println("It is working");
		LOG.info("A method from EmployeeServiceImpl was invoked.");
	}
	
	
}

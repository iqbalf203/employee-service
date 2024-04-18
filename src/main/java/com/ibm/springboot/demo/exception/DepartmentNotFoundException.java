package com.ibm.springboot.demo.exception;

public class DepartmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4373158775284035841L;

	public DepartmentNotFoundException(Exception e) {
		super("Department not found",e);
	}

	public DepartmentNotFoundException() {
		super();
	}

}

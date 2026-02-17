package com.ahmed.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException(String msg) {
		super(msg);
	}

}

package com.ahmed.ExceptionalHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ahmed.exceptions.EmployeeAlreadyExistException;
import com.ahmed.exceptions.EmployeeNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class) // Spring needs to know which exception types this method should
														// handle.
														// .class is a Java keyword used to get the Class object of a
														// class.
	public ResponseEntity<String> employeeNotFound(EmployeeNotFoundException ex) {  //The thrown exception object

		return new ResponseEntity<String>("Error : " + ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmployeeAlreadyExistException.class)
	public ResponseEntity<String> employeeAlreadyExist(EmployeeAlreadyExistException ex) {

		return new ResponseEntity<String>("Error  : " + ex.getMessage(), HttpStatus.CONFLICT);
	}
}

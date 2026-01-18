package com.ahmed.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.entity.Employee;
import com.ahmed.exceptions.EmployeeAlreadyExistException;
import com.ahmed.exceptions.EmployeeNotFoundException;
import com.ahmed.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController(value = "employeeController")
@Tag(name = "Employee" , description = "Employee Rest API End points")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping(value = "/employee/{id}")
	
	@Operation(summary = "Get Employee by Id", description = "Fetch Employee With the given id")
	
	@ApiResponse(responseCode = "200" , description = "Employee sucessfully Fetched")
	
	@ApiResponse(responseCode = "404" , description = "Employee with the given id is NOT FOUND")
	
	public ResponseEntity<Employee> getEmployeeById(@Parameter(description = "Id of the Employee to fetch") @PathVariable Long id) {
		
		Employee employee = service.fetchEmployeeById(id);
		if (employee != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);// means successful request and response send
																			// to client successfully
		} else {
			throw new EmployeeNotFoundException("Employee with id : " + id + " does not exist in DataBase");
		}
	}

	@GetMapping(value = "/employee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> emp = service.fetchEmployees();
		if (emp == null) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
		}
	}

	@PostMapping(value = "/add", consumes = {"application/json" }, produces = { 
			"application/json" })
	
	@Operation(summary = "Add the Employee", description = "Adds a new Employee to the DB, by accepting the employe in the request body")
	
	@ApiResponse(responseCode = "201",description = "Employee Added Sucessfully")
	
	@ApiResponse(responseCode = "409",description = "Employee Alerady Exist in DB")

	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		Employee employee = service.saveEmployee(emp);
		if (employee == null) { // if employee already exist then duplicate error nothing but conflict
			throw new EmployeeAlreadyExistException("Employee with the id : "+ emp.getEmpno() + "  Already Exist");
		} else {
			return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
		}
	}

	@PutMapping(value = "/update")
	
	@Operation(summary = "Updating the FullEmployee Data", description = "Updating the Employee in db, by accepting data in request body")
	
	@ApiResponse(responseCode = "200",description = "Employee has been Updated to DB")
	
	@ApiResponse(responseCode = "404",description = "Employee With the given Id is NOT FOUND")
	

	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		Employee updateEmp = service.updateEmployee(emp);
		if (updateEmp == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Employee>(updateEmp, HttpStatus.OK);

		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> removeEmployee(@PathVariable("id") Long empno) {
		Boolean flag = service.deleteById(empno); // if the employee deleted then it flag return true
		if (flag == true) {
			return new ResponseEntity<String>("Employee deleted!!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Employee Not Found!!! ", HttpStatus.NOT_FOUND);
		}

	}

	@PatchMapping(value = "/update/{id}")
	public ResponseEntity<Employee> partialUpdate(@PathVariable("id") Long empno,
			@RequestBody Map<String, Object> fields) {

		Employee updateEmployeeById = service.updateEmployeeById(empno, fields);
		if (updateEmployeeById == null) { // checking whether the employee == null or not
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Employee>(updateEmployeeById, HttpStatus.OK);
		}

	}

}

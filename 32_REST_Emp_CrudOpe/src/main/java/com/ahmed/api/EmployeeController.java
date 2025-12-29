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
import com.ahmed.service.EmployeeService;

@RestController(value = "employeeController")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping(value = "/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = service.fetchEmployeeById(id);
		if (employee != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);// means successful request and response send
																			// to client successfully
		} else {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
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

	@PostMapping(value = "/add")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		Employee employee = service.saveEmployee(emp);
		if (employee == null) { // if employee already exist then duplicate error nothing but conflict
			return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		Employee updateEmp = service.updateEmployee(emp);
		if (updateEmp == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Employee>(updateEmp, HttpStatus.OK);

		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> removeEmployee(@RequestBody @PathVariable("id") Long empno) {
		Boolean flag = service.deleteById(empno); // if the employee deleted then it flag return true
		if (flag == true) {
			return new ResponseEntity<String>("Employee deleted!!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Employee Not Found!!! ", HttpStatus.NOT_FOUND);
		}

	}

	@PatchMapping(value = "/update/{id}")
	public ResponseEntity<Employee> partialUpdate(@RequestBody @PathVariable("id") Long empno, Map<String, Object> fieldmap) {

		Employee updateEmployeeById = service.updateEmployeeById(empno, fieldmap);
		if (updateEmployeeById == null) {  // checking whether the employee == null or not
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Employee>(updateEmployeeById, HttpStatus.OK);
		}

	}

}

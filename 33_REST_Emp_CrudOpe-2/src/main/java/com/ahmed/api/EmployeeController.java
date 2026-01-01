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

	@GetMapping(value = "/employee/{id}", produces = {"application/xml","application/json"})
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
		Employee fetchEmployeeById = service.fetchEmployeeById(id);
		if (fetchEmployeeById == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Employee>(fetchEmployeeById, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> fetchAll = service.fetchAll();
		if (fetchAll == null) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Employee>>(fetchAll, HttpStatus.OK);
		}
	}

	@PostMapping(value = "/add", consumes = { "application/json", "application/xml" }, produces = { "applicatin/json",
			"application/xml" })
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		Employee saveEmployee = service.saveEmployee(emp);
		if (saveEmployee != null) {
			return new ResponseEntity<Employee>(saveEmployee, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee emp) {
		Employee updateEmployee = service.updateEmployee(emp);
		if (updateEmployee == null) {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Employee>(updateEmployee, HttpStatus.OK);
		}

	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable Integer id) {
		boolean deleteEmployee = service.deleteEmployee(id);
		if (deleteEmployee == true) {
			return new ResponseEntity<String>("Employee With the given Id is delted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Employee Not Found", HttpStatus.NOT_FOUND);

		}
	}

	@PatchMapping(value = "/update/{id}")
	public ResponseEntity<Employee> particallyUpdate(@PathVariable Integer id, @RequestBody Map<String, Object> field) {
		Employee partial = service.partial(id, field);
		if (partial == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Employee>(partial, HttpStatus.CREATED);
		}
	}

}

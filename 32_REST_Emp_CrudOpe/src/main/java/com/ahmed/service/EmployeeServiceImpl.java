package com.ahmed.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.entity.Employee;
import com.ahmed.repository.EmployeeRepository;

@Service(value = "employeeService")

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public Employee fetchEmployeeById(Long empno) { // fetching employee based on the id

		Optional<Employee> byId = repository.findById(empno);// it return the entity with the given id

		if (byId.isPresent()) {
			return byId.get();
		} else
			return null;

	}

	@Override
	public List<Employee> fetchEmployees() { // fetching all the employees

		return repository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		if (repository.existsById(emp.getEmpno())) { // here first checking weather the employee with the id is present
														// if present then returns null, if not then save the employee
			return null;
		}
		return repository.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		if (repository.existsById(employee.getEmpno())) { // here retrieving the employee based on the id, if present
															// then update, other wise return null.
			return repository.save(employee);
		} else {
			return null;
		}

	}

	@Override
	public Boolean deleteById(Long empno) {
		boolean byId = repository.existsById(empno); // if employee exist then
		if (byId) {
			repository.deleteById(empno); // delete that employee
			return true; // if deleted then return true
		} else {
			return false; // else return false
		}
	}

	@Override
	public Employee updateEmployeeById(Long empno, Map<String, Object> mapField) {
		/*
		 * • in map the objects are stored in key and value format • key is string but
		 * value is in object format so we need to type caste to specific type • before
		 * updating the employee first we have to check whether the employee exist or
		 * not • if exist then then read the values from the map then typeCaste it and
		 * call the method defined in repository • then return the updated employee,
		 * call it from DB by using FindById() method
		 */
		if (repository.existsById(empno)) {

			Double sal = (Double) mapField.get("sal");
			Integer dept = (Integer) mapField.get("dept");

			repository.partialUpdateEmployee(sal, dept, empno);
			return repository.findById(empno).get();// returning the updated employee to the client

		} else {
			return null;
		}

	}

}

package com.ahmed.service;

import java.util.List;
import java.util.Map;

import com.ahmed.entity.Employee;

public interface EmployeeService {

	Employee fetchEmployeeById(Long empno);

	List<Employee> fetchEmployees();

	Employee saveEmployee(Employee emp);

	Employee updateEmployee(Employee employee);

	Boolean deleteById(Long empno);

	Employee updateEmployeeById(Long empno, Map<String, Object> mapField);// here i want to update the employee using
																			// some fields only so take Map object

}

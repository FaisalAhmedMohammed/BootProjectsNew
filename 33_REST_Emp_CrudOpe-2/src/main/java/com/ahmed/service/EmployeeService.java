package com.ahmed.service;

import java.util.List;
import java.util.Map;

import com.ahmed.entity.Employee;

public interface EmployeeService {

	Employee fetchEmployeeById(Integer empid);

	List<Employee> fetchAll();

	Employee saveEmployee(Employee emp);

	Employee updateEmployee(Employee emp);

	boolean deleteEmployee(Integer empid);

	Employee partial(Integer id, Map<String, Object> filed);
}

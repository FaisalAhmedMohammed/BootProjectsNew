package com.ahmed.service;

import com.ahmed.entity.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee);

	Employee getEmployee(String name);

	void updateEmployeeAddress(Long empid, String name);

}

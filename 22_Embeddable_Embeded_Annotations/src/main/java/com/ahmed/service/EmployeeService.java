package com.ahmed.service;

import org.springframework.data.expression.ValueEvaluationContextProvider;

import com.ahmed.entity.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee);

	Employee getEmployee(String name);

	void updateEmployeeAddress(Long empid, String name);

}

package com.ahmed.service;

import org.springframework.data.domain.Page;

import com.ahmed.entity.Employee;

public interface EmployeeService {

	public Page<Employee> FetchAllEmp(int page, int size);

}

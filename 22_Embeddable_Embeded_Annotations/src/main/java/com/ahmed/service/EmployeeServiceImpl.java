package com.ahmed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.entity.Employee;
import com.ahmed.repository.EmployeeRepo;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public Employee addEmployee(Employee employee) {

		return employeeRepo.save(employee);
	}

	@Override
	public Employee getEmployee(String name) {
		return employeeRepo.findByName(name);

	}

	@Override
	public void updateEmployeeAddress(Long empid, String name) {
		int updateEmployee = employeeRepo.updateEmployee(empid, name);
		System.out.println("Employee with id :" + updateEmployee + "is Updated");
	}

}

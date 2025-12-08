package com.ahmed.service;

import java.util.List;

import com.ahmed.entity.Address;
import com.ahmed.entity.Employee;

public interface EmployeeService {
	
	Employee addAddress(Employee employee, List<Address> address);
	
	Employee saveEmployee(Employee employee);
	
	Employee loadEmployee(Long empid);
	 
	void deleteEmpById(Long empid);
	

}

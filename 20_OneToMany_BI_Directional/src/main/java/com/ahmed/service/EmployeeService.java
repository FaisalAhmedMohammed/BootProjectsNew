package com.ahmed.service;

import java.util.List;

import com.ahmed.entity.Address;
import com.ahmed.entity.Employee;

public interface EmployeeService {

	Address addEmployee(Employee employee, Address address);

	Employee addAddress(Employee employee, List<Address> address);
	
	Employee saveEmployee(Employee employee);
	
	Address saveAddress(Address address);
	
	Employee loadEmployee(Long empid);
	
	boolean deleteEmp(String ename);

}

package com.ahmed.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.entity.Address;
import com.ahmed.entity.Employee;
import com.ahmed.repostitory.AddressRepo;
import com.ahmed.repostitory.EmployeeRepo;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	AddressRepo addressRepo;

	@Override
	public Address addEmployee(Employee employee, Address address) {
		address.setEmployee(employee);// setting employee(parent) address
		return address;
	}

	@Override
	public Employee addAddress(Employee employee, List<Address> address) {
		employee.setAddresses(address);// setting address(child) to employee(parent)
		return employee;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}

	@Override
	public Employee loadEmployee(Long empid) {
		Optional<Employee> byId = employeeRepo.findById(empid);
		if (byId.isPresent()) {
			return byId.get();

		}
		return null;
	}

	@Override
	public boolean deleteEmp(String ename) {

		int count = employeeRepo.removeEmployee(ename);
		return count > 0;
	}

	@Override
	public Address loadById(Long addId) {

		Optional<Address> byId = addressRepo.findById(addId);
		if (byId.isPresent()) {
			Address address = byId.get();
			return address;
		}
		return null;

	}

}

package com.ahmed.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.entity.Address;
import com.ahmed.entity.Employee;
import com.ahmed.repo.AddressRepo;
import com.ahmed.repo.EmployeeRepo;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	AddressRepo addressRepo;

	@Override
	public Employee addAddress(Employee employee, List<Address> address) {
		employee.setAddress(address);
		return employee;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
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
	public void deleteEmpById(Long empid) {
		employeeRepo.deleteById(empid);

	}

}

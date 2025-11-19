package com.ahmed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.model.Employee;
import com.ahmed.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	public void saveEmployee(Employee e) {
		empRepository.save(e);
		System.out.println("Employee record is saved in DB");

	}

	public void updateEmployee(int empno, double sal) {
		empRepository.update(empno, sal);
		System.out.println("Employee is updated successfully");

	}

	public void deleteEmployee(int empno) {
		empRepository.delete(empno);
		System.out.println("Employee is deleted successfully");

	}

	public void getById(int empno) {
		empRepository.findById(empno);
		System.out.println("Employee Retrived ");

	}

	public void getAll() {
		empRepository.getAll();
	}

}

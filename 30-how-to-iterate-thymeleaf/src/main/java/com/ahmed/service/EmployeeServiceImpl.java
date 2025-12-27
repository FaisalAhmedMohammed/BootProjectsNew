package com.ahmed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ahmed.entity.Employee;
import com.ahmed.repository.EmployeeRepository;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	@Override
	public Page<Employee> FetchAllEmp(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by("sal").descending());
		return empRepository.findAll(pageRequest); // this findAll methd returns page object it contains how many
													// records,current page, it has previous page or not or it has a
													// next page or not, totally how many pages are there
	}

}

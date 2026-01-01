package com.ahmed.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.entity.Employee;
import com.ahmed.repository.EmployeeRepository;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public Employee fetchEmployeeById(Integer empid) {
		Optional<Employee> byId = repository.findById(empid);
		if (byId.isPresent()) {
			return byId.get();
		}
		return null;
	}

	@Override
	public List<Employee> fetchAll() {
		return repository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		if (repository.existsById(emp.getEmpid())) {
			return null;
		} else {
			return repository.save(emp);
		}
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		if (repository.existsById(emp.getEmpid())) {
			return repository.save(emp);
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteEmployee(Integer empid) {

		boolean existsById = repository.existsById(empid);
		if (existsById) {
			repository.deleteById(empid);
			return true;
		}

		return false;
	}

	@Override
	public Employee partial(Integer id, Map<String, Object> filed) {

		if (repository.existsById(id)) {
			
			Double sal = (Double) filed.get("sal");
			Integer dept = (Integer) filed.get("dept");
			
			repository.updatePartial(sal, dept, id);
			return repository.findById(id).get();
		} else {
			return null;
		}

	}

}

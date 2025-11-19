package com.ahmed.service;
/*•	To avoid create db table in runner component and inserting records in runner component, we can create two files in application.properties file 
1)	Schema.sql - used to create/alter/drop/truncate
2)	Data.sql -- used to insert/update/delete the records

•	And we need to add this in application.properties files 
    spring.sql.init.mode=always*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.model.Employee;
import com.ahmed.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	EmpRepository empRepository;

	public void saveEmployee(Employee e) {
		empRepository.save(e);
		System.out.println("Employee saved in db");
	}

	public void updateEmployee(int empno, double sal) {
		empRepository.update(empno, sal);
		System.out.println("Employee Record Updated");
	}

	public void deleteEmployee(int empno) {
		empRepository.delete(empno);
		System.out.println("Employee Record Deleted");
	}

	public void getById(int empno) {
		empRepository.findById(empno);

	}

	public void getAll() {
		empRepository.findAll();
	}

}

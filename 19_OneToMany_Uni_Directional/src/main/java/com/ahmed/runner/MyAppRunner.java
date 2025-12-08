package com.ahmed.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ahmed.entity.Address;
import com.ahmed.entity.Employee;
import com.ahmed.service.EmployeeService;

@Component(value = "runner")

public class MyAppRunner implements ApplicationRunner {

	@Autowired
	EmployeeService employeeService;

	@Transactional
	@Override
	public void run(ApplicationArguments args) throws Exception {

		// saveEmployee();
		getEmp(101L);

	}

	private void saveEmployee() {

		Employee emp1 = new Employee();
		emp1.setEname("SOPHIA");
		emp1.setSal(5000.0);

		Address add1 = new Address();
		add1.setCity("ORIENT");
		add1.setState("NEW_YORK");
		add1.setType("PERMENENT");
		add1.setPincode(503001L);

		Address add2 = new Address();
		add2.setCity("LAKE");
		add2.setState("CHICAGO");
		add2.setType("TEMPORARY");
		add2.setPincode(503005L);

		List<Address> list = Arrays.asList(add1, add2);

		emp1.setAddress(list);

		employeeService.saveEmployee(emp1);
		System.out.println("Employee with Address are inserted in DataBase");
		System.out.println("Employee Address 1 id is :" + add1.getAddId());
		System.out.println("Employee Address 2 id is :" + add2.getAddId());

	}

	private void getEmp(Long id) {

		Employee employee = employeeService.loadEmployee(id);
		System.out.println(employee.getEmpid());
		System.out.println(employee.getEname());
		System.out.println(employee.getSal());

		// here parent record is retrieving but not the child so here we are retrieving
		// child object based on demand

		System.out.println("=".repeat(151));
		List<Address> address = employee.getAddress();
		address.forEach(System.out::println);

	}

}

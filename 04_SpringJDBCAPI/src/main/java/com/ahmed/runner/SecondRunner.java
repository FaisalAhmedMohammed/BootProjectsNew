package com.ahmed.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ahmed.model.Employee;
import com.ahmed.service.EmployeeService;

@Order(value = 2)
@Component
public class SecondRunner implements ApplicationRunner {

	@Autowired
	EmployeeService empService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Employee emp = new Employee(1234, "ashok", 6999, 12);
		empService.saveEmployee(emp);
		System.out.println("*".repeat(50));

		empService.updateEmployee(7744, 9999.0);
		System.out.println("*".repeat(50));

		empService.deleteEmployee(7876);
		System.out.println("*".repeat(50));

		empService.getById(1234);
		System.out.println("*".repeat(50));

		empService.getAll();
		System.out.println("*".repeat(50));
	}

}

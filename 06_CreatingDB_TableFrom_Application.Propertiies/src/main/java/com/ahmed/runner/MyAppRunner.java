package com.ahmed.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ahmed.model.Employee;
import com.ahmed.service.EmpService;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	EmpService empService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Employee emp = new Employee(1111, "trump", 1000.0, 10);
		empService.saveEmployee(emp);
		System.out.println("=".repeat(60));

		empService.updateEmployee(7788, 10000.0);
		System.out.println("=".repeat(60));

		empService.deleteEmployee(7606);
		System.out.println("=".repeat(60));

		empService.getById(1234);
		System.out.println("=".repeat(60));

		empService.getAll();
		System.out.println("=".repeat(60));
	}

}

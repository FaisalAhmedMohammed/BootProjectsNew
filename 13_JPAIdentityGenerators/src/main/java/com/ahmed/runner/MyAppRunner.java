package com.ahmed.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ahmed.entity.Customer;
import com.ahmed.repository.CustomerRepository;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	CustomerRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Customer c1 = new Customer();
		c1.setName("ALLEN");
		c1.setPhoneNo(123456789L);

		Customer c2 = new Customer();
		c2.setName("SCOTT");
		c2.setPhoneNo(987654321L);

		Customer save = repository.save(c1);
		System.out.println("Customer saved in DB");
		System.out.println(" Customer Id is  : "+ save.getId());
		
		System.out.println("=".repeat(99));
		
		Customer save2 = repository.save(c2);
		System.out.println("Customer saved in DB");
		System.out.println(" Customer Id is  : "+ save2.getId());
		
	}

}

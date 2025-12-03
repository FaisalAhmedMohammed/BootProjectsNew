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
		c1.setName("KATHEY");
		c1.setPhNo(909901L);
		Customer save = repository.save(c1);

		System.out.println(" Customer " + save.getName() + " id is : " + save.getId());
		System.out.println("=".repeat(99));

		Customer c2 = new Customer();
		c2.setName("MILLER");
		c2.setPhNo(808801L);
		Customer save2 = repository.save(c2);

		System.out.println(" Customer " + save2.getName() + " id is : " + save2.getId());
		System.out.println("=".repeat(99));
	}

}

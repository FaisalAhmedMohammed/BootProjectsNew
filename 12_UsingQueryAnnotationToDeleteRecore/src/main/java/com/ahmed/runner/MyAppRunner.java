package com.ahmed.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ahmed.service.OrderService;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	OrderService orderService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		orderService.deleteById(10997L);
		System.out.println("Order with the given id is deleted");

	}

}

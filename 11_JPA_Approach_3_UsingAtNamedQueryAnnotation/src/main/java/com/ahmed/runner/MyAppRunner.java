package com.ahmed.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ahmed.entity.Order;
import com.ahmed.service.OrderService;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	OrderService orderService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		List<Order> fetchAllOrders = orderService.fetchAllOrders();
		fetchAllOrders.forEach(System.out::println);

		System.out.println("=".repeat(99));

		List<Order> retriveAllOrders = orderService.retriveAllOrders();
		retriveAllOrders.forEach(System.out::println);
		System.out.println("=".repeat(99));

		Order customerById = orderService.getCustomerById(104L);
		System.out.println(customerById);
		System.out.println("=".repeat(99));

	}

}

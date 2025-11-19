package com.ahmed.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ahmed.model.Order;
import com.ahmed.service.OrderService;


@Component

public class SecondRunner implements ApplicationRunner {

	@Autowired
	OrderService orderService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Order order = new Order(7861, "CHARGER", 2500.0, "DELIVERED");

		orderService.saveOrder(order);
		System.out.println("*".repeat(50));

		orderService.updateOrder(105, "CANCLED");
		System.out.println("*".repeat(50));

		orderService.deleteOrder(105);
		System.out.println("*".repeat(50));

		orderService.getOrderById(101);
		System.out.println("*".repeat(50));

		orderService.getAllOrders();
	}
}

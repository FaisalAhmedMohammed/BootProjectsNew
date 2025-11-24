package com.ahmed.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ahmed.entity.Order;
import com.ahmed.entity.OrderStatus;
import com.ahmed.service.OrderService_impl;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	OrderService_impl impl;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Order ord = new Order(19001L, 101L, LocalDate.now(), OrderStatus.ORDERED);

		impl.saveOrUpdate(ord);
		System.out.println("Order saved successfully");

		System.out.println("=".repeat(90));

		Order o = impl.getOrder(19001L);
		System.out.println(o);

		System.out.println("=".repeat(90));

		Iterable<Order> all = impl.getAll();
		all.forEach(ele -> System.out.println(ele));
		System.out.println("=".repeat(90));

		/*
		 * impl.deleteOrder(19001L); System.out.println("order Deleted !!!");
		 */
	}

}

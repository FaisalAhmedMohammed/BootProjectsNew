package com.ahmed.runner;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ahmed.entity.Order;
import com.ahmed.entity.OrderStatus;
import com.ahmed.service.OrderService;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	OrderService orderService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		List<Order> order = orderService.readOrder(OrderStatus.PROCESSED.getValue(), OrderStatus.DELIVERED.getValue());
		order.forEach(System.out::println);
		System.out.println("=".repeat(99));

		List<Order> ordersWithCustomerIdOrDate = orderService.readOrdersWithCustomerIdOrDate(102L,
				LocalDate.of(2025, 11, 20));
		ordersWithCustomerIdOrDate.forEach(System.out::println);
		System.out.println("=".repeat(99));
	}

}

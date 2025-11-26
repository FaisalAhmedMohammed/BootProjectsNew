package com.ahmed.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ahmed.entity.Order;
import com.ahmed.entity.OrderStatus;
import com.ahmed.service.OrderServiceImpl;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	OrderServiceImpl impl;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		/*
		 * Order ord1 = new Order(10991L, 101L, LocalDate.now(), OrderStatus.PROCESSED);
		 * Order ord2 = new Order(10992L, 102L, LocalDate.of(2025, 11, 15),
		 * OrderStatus.DELIVERED); Order ord3 = new Order(10993L, 103L,
		 * LocalDate.of(2025, 11, 20), OrderStatus.ORDERED); Order ord4 = new
		 * Order(10994L, 104L, LocalDate.now(), OrderStatus.PROCESSED); Order ord5 = new
		 * Order(10995L, 102L, LocalDate.now(), OrderStatus.PROCESSED); Order ord6 = new
		 * Order(10996L, 101L, LocalDate.of(2025, 11, 22), OrderStatus.CANCELED); Order
		 * ord7 = new Order(10997L, 102L, LocalDate.now(), OrderStatus.CANCELED); Order
		 * ord8 = new Order(10998L, 101L, LocalDate.now(), OrderStatus.PROCESSED); Order
		 * ord9 = new Order(10999L, 102L, LocalDate.of(2025, 11, 18),
		 * OrderStatus.DELIVERED);
		 */

		/*
		 * impl.saveOrUpdate(order); System.out.println("order saved successfully");
		 */

		/*
		 * Iterable<Order> of = List.of(ord1, ord2, ord3, ord4, ord5, ord6, ord7, ord8,
		 * ord9); Iterable<Order> saveAll = impl.saveAll(of);
		 * saveAll.forEach(System.out::println);
		 */
		/*
		 * System.out.println("saved All Orders"); System.out.println("*".repeat(50));
		 */

		/*
		 * impl.deleteById(19001L); System.out.println("order deleted");
		 * System.out.println("*".repeat(50));
		 */

		Long orderId = Long.parseLong(args.getOptionValues("orderId").get(0));
		Order orderById = impl.getOrderById(orderId);
		System.out.println(orderById);
		System.out.println("order retrived based on id");
		System.out.println("*".repeat(100));

		// calling getAllOrderes method

		impl.getAll().forEach(System.out::println);
		System.out.println("All records received");
		System.out.println("*".repeat(100));

		// calling getOrdersByCustumerId method
		long long1 = Long.parseLong(args.getOptionValues("customerId").get(0));
		impl.getOrdersByCustumerId(long1).forEach(System.out::println);
		System.out.println("orders retrived based on customer id");
		System.out.println("*".repeat(100));

		// for enum we dont have any conversions like String to enum because the
		// arguments which are coming at runtime are Strings
		// calling getOrderByOrdersStatus method
		impl.getOrderByOrdersStatus(OrderStatus.DELIVERED).forEach(System.out::println);
		System.out.println("order retrived based on status");
		System.out.println("*".repeat(100));

		// calling getOrdersByDatePurchasedGreaterThan method
		impl.getOrdersByDatePurchasedGreaterThan(LocalDate.of(2025, 11, 20)).forEach(System.out::println);
		System.out.println("order retrived based on Date");
		System.out.println("*".repeat(75));

	}
}

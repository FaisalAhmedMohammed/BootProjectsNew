package com.ahmed.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ahmed.entity.Customer;
import com.ahmed.entity.Order;
import com.ahmed.entity.OrderStatus;
import com.ahmed.service.CustomerService;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	CustomerService customerService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		//saveCustomer();
		fetchOrder(101L);

	}

	private void fetchOrder(long l) {
		Order order = customerService.findOrder(l);
		System.out.println(order.getOrderId());
		System.out.println(order.getOrderStatus());
		System.out.println(order.getDatePurchased());

		System.out.println(order.getCustomer().getId());
		System.out.println(order.getCustomer().getName());
		System.out.println(order.getCustomer().getPhNo());

	}

	private void saveCustomer() {

		Customer Customer = new Customer();// creating customer
		Customer.setName("JOHN");
		Customer.setPhNo(900981L);

		// creating orders
		Order order1 = new Order(101L, LocalDate.of(2024, 10, 12), OrderStatus.Ordered, null);
		Order order2 = new Order(102L, LocalDate.of(2024, 11, 05), OrderStatus.DELIVERED, null);
		Order order3 = new Order(103L, LocalDate.of(2024, 10, 21), OrderStatus.CANCELED, null);
		Order order4 = new Order(104L, LocalDate.of(2024, 11, 15), OrderStatus.PROCESSED, null);
		Order order5 = new Order(105L, LocalDate.of(2024, 12, 04), OrderStatus.Ordered, null);

		// setting orders to customer or orders or aware of customer
		customerService.addCustomer(Customer, order1);
		customerService.addCustomer(Customer, order2);
		customerService.addCustomer(Customer, order3);
		customerService.addCustomer(Customer, order4);
		customerService.addCustomer(Customer, order5);

		List<Order> list = Arrays.asList(order1, order2, order3, order4, order5);

		// setting customer to order
		Customer = customerService.addOrders(Customer, list);

		// saving order
		customerService.saveCustomer(Customer);
		System.out.println("Customer With Orders are Placed  in to the DataBase");
		System.out.println("The customer id generated is : " + Customer.getId());
	}

}

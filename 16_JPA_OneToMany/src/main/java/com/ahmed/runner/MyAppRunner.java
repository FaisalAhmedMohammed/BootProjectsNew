package com.ahmed.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ahmed.entity.Customer;
import com.ahmed.entity.Order;
import com.ahmed.entity.OrderStatus;
import com.ahmed.service.CustomerService;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	CustomerService customerService;

	@Transactional
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// getOrder();
		//loadCustomer();
		removeCustomer();
	}

	public void getOrder() {
		Customer customer = new Customer();
		customer.setName("JOHN");
		customer.setPhNo(190091L);

		List<Order> list = Arrays.asList(new Order(1799901L, LocalDate.of(2024, 11, 10), OrderStatus.ORDERED),
				new Order(1799902L, LocalDate.of(2024, 11, 10), OrderStatus.ORDERED),
				new Order(1799903L, LocalDate.of(2024, 11, 05), OrderStatus.DELIVERED),
				new Order(1799904L, LocalDate.of(2024, 11, 21), OrderStatus.ORDERED),
				new Order(1799905L, LocalDate.of(2024, 10, 01), OrderStatus.CANCELED),
				new Order(1799906L, LocalDate.of(2024, 11, 10), OrderStatus.PROCESSED));

		Customer savedCustomer = customerService.addOrder(customer, list);

		System.out.println("=".repeat(99));
		System.out.println("The Customer is inserted with his orders to the data base");
		System.out.println("Customer id is : " + savedCustomer.getCustomerId());

		System.out.println("=".repeat(99));

	}

	public void loadCustomer() {
		Customer customer = customerService.fetchCustomer(1L);// this method is going to retrieve only parent table not
																// child
		System.out.println(customer.getCustomerId() + " " + customer.getName() + " " + customer.getPhNo());

		System.out.println("=".repeat(151));

		// Here we are retrieve the child record based on demand
		/*
		 * There is an annotation in JPA/Spring called @Transactional. When we add this
		 * annotation to a method, the entire method is executed as a single
		 * transaction. This means JPA will open one database connection, and it will
		 * remain open until the whole method finishes. If the method completes
		 * successfully, the transaction is committed; if any exception occurs, the
		 * entire transaction is rolled back. Download the application from the below
		 * link
		 */
		
		  List<Order> orders = customer.getOrders();
		  orders.forEach(System.out::println);
		 
	}
	public void removeCustomer() {
		customerService.deleteCustomerById(1L);
	}

}

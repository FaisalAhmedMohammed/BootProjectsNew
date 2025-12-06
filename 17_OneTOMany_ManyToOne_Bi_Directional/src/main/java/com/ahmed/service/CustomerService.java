package com.ahmed.service;

import java.util.List;

import com.ahmed.entity.Customer;
import com.ahmed.entity.Order;

public interface CustomerService {

	Customer addOrders(Customer customer, List<Order> order); // adding list of orders to the customer and return customer

	Order addCustomer(Customer customer, Order order);  // here adding customer to the order and returning order
	
	Customer saveCustomer(Customer customer);
	
	Order findOrder(Long orderId);// retrives the order and customer objects because of fetch type ALL

}

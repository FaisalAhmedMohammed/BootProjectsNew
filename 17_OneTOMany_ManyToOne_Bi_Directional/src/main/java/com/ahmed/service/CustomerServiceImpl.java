package com.ahmed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.entity.Customer;
import com.ahmed.entity.Order;
import com.ahmed.repository.CustomerRepository;
import com.ahmed.repository.OrderRepository;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderRepository orderRepository;

	@Override
	public Customer addOrders(Customer customer, List<Order> order) {// setting order to the customer
		customer.setOrders(order);

		return customer;
	}

	@Override
	public Order addCustomer(Customer customer, Order order) {// setting customer to the order

		order.setCustomer(customer);
		return order;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		customer = customerRepository.save(customer);
		return customer;
	}

	@Override
	public Order findOrder(Long orderId) {
		Order order = orderRepository.findById(orderId).get();
		return order;
	}

}

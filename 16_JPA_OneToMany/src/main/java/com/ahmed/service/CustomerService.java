package com.ahmed.service;

import java.util.List;

import com.ahmed.entity.Customer;
import com.ahmed.entity.Order;

public interface CustomerService {

	Customer addOrder(Customer customer, List<Order> order);

	//Customer saveCustomer(Customer customer);

	Customer fetchCustomer(Long customerId);

	void deleteCustomerById(Long customerId);

}

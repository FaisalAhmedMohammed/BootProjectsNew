package com.ahmed.service;

import java.util.List;

import com.ahmed.entity.Order;

public interface OrderService {

	List<Order> fetchAllOrders();

	List<Order> retriveAllOrders();
	
	// fetching order by customer id using findBy methods
	Order getCustomerById(Long customerId);

}

package com.ahmed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.entity.Order;
import com.ahmed.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Override
	public List<Order> fetchAllOrders() {
		return orderRepository.findAllOrders();
	}

	@Override
	public List<Order> retriveAllOrders() {
		return orderRepository.getAllOrders();
	}
	@Override
	public Order getCustomerById(Long customerId) {
		return orderRepository.findBycustomerId(customerId);
	}

}

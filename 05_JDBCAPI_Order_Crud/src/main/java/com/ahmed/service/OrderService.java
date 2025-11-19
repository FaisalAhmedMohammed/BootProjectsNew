package com.ahmed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.model.Order;
import com.ahmed.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public void saveOrder(Order order) {
		orderRepository.save(order);
		System.out.println("Order added to cart");
	}

	public void updateOrder(int orderId, String status) {
		orderRepository.update(orderId, status);
		System.out.println("Order Updated Succesdfully");
	}

	public void deleteOrder(int orderId) {
		orderRepository.delete(orderId);
		System.out.println("Order deleted Successfully");
	}

	public void getOrderById(int orderId) {
		orderRepository.findById(orderId);
	}

	public void getAllOrders() {
		orderRepository.findAll();
	}

}

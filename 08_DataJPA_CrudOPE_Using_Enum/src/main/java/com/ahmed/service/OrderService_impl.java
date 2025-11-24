package com.ahmed.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.entity.Order;
import com.ahmed.repository.OrderRepository;

@Service
public class OrderService_impl implements OrderService {

	@Autowired
	OrderRepository ordeRepository;

	@Override
	public Order saveOrUpdate(Order order) {
		return ordeRepository.save(order);
	}

	@Override
	public Order getOrder(Long orderId) {

		Optional<Order> byId = ordeRepository.findById(orderId);
		if (byId.isPresent()) {
			return byId.get();
		}
		return null;
	}

	@Override
	public Iterable<Order> getAll() {

		return ordeRepository.findAll();
	}

	@Override
	public void deleteOrder(Long orderId) {
		ordeRepository.deleteById(orderId);

	}

}

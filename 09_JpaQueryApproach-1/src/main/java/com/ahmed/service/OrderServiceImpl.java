package com.ahmed.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.entity.Order;
import com.ahmed.entity.OrderStatus;
import com.ahmed.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	/*
	 * @Override public Order saveOrUpdate(Order order) { return
	 * orderRepository.save(order); }
	 */
	/*
	 * @Override public Iterable<Order> saveAll(Iterable<Order> order) { return
	 */

	/*
	 * @Override public void deleteById(Long OrderId) {
	 * orderRepository.deleteById(OrderId); }
	 */

	@Override
	public Iterable<Order> getAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderById(Long OrderId) {

		Optional<Order> byId = orderRepository.findById(OrderId);
		if (byId.isPresent()) {
			return byId.get();
		}
		return null;
	}

	@Override
	public List<Order> getOrdersByCustumerId(Long customerId) {

		return orderRepository.findByCustomerId(101L);
	}

	@Override
	public List<Order> getOrderByOrdersStatus(OrderStatus orderStatus) {
		return orderRepository.findByOrderStatus(OrderStatus.DELIVERED);

	}

	@Override
	public List<Order> getOrdersByDatePurchasedGreaterThan(LocalDate datePurchased) {
		return orderRepository.findByDatePurchasedGreaterThan(datePurchased);
	}

}

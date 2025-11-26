package com.ahmed.service;

import java.time.LocalDate;
import java.util.List;

import com.ahmed.entity.Order;
import com.ahmed.entity.OrderStatus;

public interface OrderService {

	// Order saveOrUpdate(Order order);

	// Iterable<Order>saveAll(Iterable<Order> order);

	// void deleteById(Long OrderId);

	Order getOrderById(Long OrderId);

	Iterable<Order> getAll();

	List<Order> getOrdersByCustumerId(Long customerId);

	List<Order> getOrderByOrdersStatus(OrderStatus orderStatus);

	List<Order> getOrdersByDatePurchasedGreaterThan(LocalDate datePurchased);

}

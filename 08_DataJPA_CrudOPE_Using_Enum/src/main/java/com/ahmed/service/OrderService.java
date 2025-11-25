package com.ahmed.service;

import java.util.List;

import com.ahmed.entity.Order;

public interface OrderService {

	public Iterable<Order> saveAll(List<Order> orders);

	public Order getOrder(Long orderId);

	public Iterable<Order> getAll();

	public void deleteOrder(Long orderId);

}

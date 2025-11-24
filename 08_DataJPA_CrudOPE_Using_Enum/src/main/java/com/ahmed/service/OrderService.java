package com.ahmed.service;

import com.ahmed.entity.Order;

public interface OrderService {

	public Order saveOrUpdate(Order order);

	public Order getOrder(Long orderId);

	public Iterable<Order> getAll();

	public void deleteOrder(Long orderId);

}

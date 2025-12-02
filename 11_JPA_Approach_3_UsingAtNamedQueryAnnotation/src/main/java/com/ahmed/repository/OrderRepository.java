package com.ahmed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findAllOrders();

	List<Order> getAllOrders();
	
	Order findBycustomerId(Long customerId);

}

package com.ahmed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ahmed.entity.Order;

import jakarta.transaction.Transactional;

public interface OrderRepository extends JpaRepository<Order, Long> {

	@Modifying
	@Transactional
	@Query("DELETE FROM Order o WHERE o.orderId = ?1")
	void deleteOrderById(Long OrderId);

}

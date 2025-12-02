package com.ahmed.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ahmed.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query(value = "SELECT * FROM neworders WHERE order_status = ?1 OR order_status = ?2", nativeQuery = true)
	List<Order> getOrderWithStatus(String status1, String status2);

	@Query("SELECT o FROM Order o WHERE o.customerId = ?1 OR o.datePurchased = ?2")
	List<Order> fetchOrdersWithCustomerIdOrDatePurchased(Long customerId, LocalDate datePurchased);

}

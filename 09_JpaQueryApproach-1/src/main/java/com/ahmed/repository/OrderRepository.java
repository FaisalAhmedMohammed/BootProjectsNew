package com.ahmed.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahmed.entity.Order;
import com.ahmed.entity.OrderStatus;
/*Here we are retriving the records based on non-primary key columns
 * using findBy methods*/
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

	List<Order> findByCustomerId(Long CustomerId);

	List<Order> findByOrderStatus(OrderStatus orderStatus);

	List<Order> findByDatePurchasedGreaterThan(LocalDate datePurchased);

}

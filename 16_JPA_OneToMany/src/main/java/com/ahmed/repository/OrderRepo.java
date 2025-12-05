package com.ahmed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

}

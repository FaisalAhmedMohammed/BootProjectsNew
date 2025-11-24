package com.ahmed.repository;

import org.springframework.data.repository.CrudRepository;

import com.ahmed.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}

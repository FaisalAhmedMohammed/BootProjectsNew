package com.ahmed.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.entity.Order;
import com.ahmed.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository repository;

	@Override
	public List<Order> readOrder(String status1, String status2) {
		return repository.getOrderWithStatus(status1, status2);
	}

	@Override
	public List<Order> readOrdersWithCustomerIdOrDate(Long CustomerId, LocalDate datePurchased) {
		return repository.fetchOrdersWithCustomerIdOrDatePurchased(CustomerId, datePurchased);
	}
	
	
	

}

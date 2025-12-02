package com.ahmed.service;

import java.time.LocalDate;
import java.util.List;

import com.ahmed.entity.Order;

public interface OrderService {

	List<Order> readOrder(String processed, String delivered);

	List<Order> readOrdersWithCustomerIdOrDate(Long CustomerId, LocalDate datePurchased);

}

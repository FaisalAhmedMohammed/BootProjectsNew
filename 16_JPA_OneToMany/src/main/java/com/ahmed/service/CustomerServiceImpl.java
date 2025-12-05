package com.ahmed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.entity.Customer;
import com.ahmed.entity.Order;
import com.ahmed.repository.CustomerRepo;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo CustomerRepo;

	@Override
	public Customer addOrder(Customer customer, List<Order> order) {
		customer.setOrders(order);
		return CustomerRepo.save(customer);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		Customer save = CustomerRepo.save(customer);
		return save;
	}

	@Override
	public Customer fetchCustomer(Long customerId) {
		return CustomerRepo.findById(customerId).get();
	}

	@Override
	public void deleteCustomerById(Long customerId) {
		CustomerRepo.deleteById(customerId);

	}

}

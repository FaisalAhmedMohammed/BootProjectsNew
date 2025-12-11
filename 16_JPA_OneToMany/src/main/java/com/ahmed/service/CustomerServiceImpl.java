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
	public Customer addOrder(Customer customer, List<Order> order) {// setting list of orders to the customer
		customer.setOrders(order);
		return CustomerRepo.save(customer); // returning the customer this customer we will save in db and directly
											// saving or we can save in below method
	}

	/*
	 * @Override public Customer saveCustomer(Customer customer) { Customer save =
	 * CustomerRepo.save(customer); // saving the customer and returns the instance
	 * saved in db return save; }
	 */

	@Override
	public Customer fetchCustomer(Long customerId) {
		return CustomerRepo.findById(customerId).get();
	}

	@Override
	public void deleteCustomerById(Long customerId) {
		CustomerRepo.deleteById(customerId);

	}

}

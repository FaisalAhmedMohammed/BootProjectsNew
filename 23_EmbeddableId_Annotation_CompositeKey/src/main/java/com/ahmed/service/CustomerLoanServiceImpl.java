package com.ahmed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.entity.CustomerLoan;
import com.ahmed.repository.CustomerRepository;

@Service(value = "customerService")
public class CustomerLoanServiceImpl implements CustomerLoanService {

	@Autowired
	CustomerRepository repository;

	@Override
	public CustomerLoan saveCustomerWithId(CustomerLoan loan) {

		return repository.save(loan);
	}

}

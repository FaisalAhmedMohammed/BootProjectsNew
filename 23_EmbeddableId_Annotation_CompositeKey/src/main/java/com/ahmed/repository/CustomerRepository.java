package com.ahmed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.entity.CustomerLoan;
import com.ahmed.entity.CustomerLoanId;

public interface CustomerRepository extends JpaRepository<CustomerLoan, CustomerLoanId> {

}

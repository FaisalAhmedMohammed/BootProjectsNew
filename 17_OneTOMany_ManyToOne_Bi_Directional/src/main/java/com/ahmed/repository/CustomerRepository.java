package com.ahmed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

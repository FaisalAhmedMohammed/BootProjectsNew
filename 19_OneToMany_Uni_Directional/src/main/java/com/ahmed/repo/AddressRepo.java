package com.ahmed.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}

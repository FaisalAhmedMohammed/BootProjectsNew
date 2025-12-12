package com.ahmed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.entity.Passport;

public interface PassportRepo extends JpaRepository<Passport, Long> {

}

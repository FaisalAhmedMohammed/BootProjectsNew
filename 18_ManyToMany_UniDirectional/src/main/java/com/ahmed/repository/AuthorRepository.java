package com.ahmed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.entity.Authors;

public interface AuthorRepository extends JpaRepository<Authors, Long> {

}

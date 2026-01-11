package com.ahmed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.entity.Author;

public interface AuthorRepo extends JpaRepository<Author, Long> {

}

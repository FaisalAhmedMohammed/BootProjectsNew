package com.ahmed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}

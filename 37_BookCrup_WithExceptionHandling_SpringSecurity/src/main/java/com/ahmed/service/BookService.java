package com.ahmed.service;

import java.util.List;

import com.ahmed.entity.Book;

public interface BookService {

	public Book save(Book saveBook);

	public Book fetchBookById(Integer id);

	public List<Book> fetchAll();

	public void deleteById(Integer id);

}

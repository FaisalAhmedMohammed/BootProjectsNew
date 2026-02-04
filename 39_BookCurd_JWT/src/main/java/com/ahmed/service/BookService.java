package com.ahmed.service;

import java.util.List;

import com.ahmed.entity.Book;

public interface BookService {

	public Book saveBook(Book saveBook);

	public Book fetchBookById(Integer id);

	public List<Book> fetchAll();

	public void deleteBookById(Integer id);

}

package com.ahmed.service;

import java.util.List;

import com.ahmed.entity.Authors;
import com.ahmed.entity.Book;

public interface BookService {

	Book addAuthors(Book book, List<Authors> authors);

	Book saveBook(Book book);

	Book loadBook(Long id);

	void deleteById(Long id);

}

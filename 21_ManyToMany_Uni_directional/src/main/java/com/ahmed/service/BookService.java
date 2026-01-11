package com.ahmed.service;

import java.util.List;

import com.ahmed.entity.Author;
import com.ahmed.entity.Book;

public interface BookService {

	Author addBooks(Author author, List<Book> books);
	
	Author saveAuthor(Author author);
	
	
	
	Book addAuthors(Book book, List<Author> autho);

	Book saveBook(Book book);

	Book loadBook(Long id);

	Boolean removeBook(Long id);

}

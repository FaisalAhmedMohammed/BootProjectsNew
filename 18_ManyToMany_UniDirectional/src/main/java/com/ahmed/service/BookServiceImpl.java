package com.ahmed.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.entity.Authors;
import com.ahmed.entity.Book;
import com.ahmed.repository.BookRepository;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public Book addAuthors(Book book, List<Authors> authors) {
		book.setAuthors(authors); // settings list of authors(child) to book
		return book;
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);  // saving the book(parent)
	}

	@Override
	public Book loadBook(Long id) {

		Optional<Book> byId = bookRepository.findById(id);
		if (byId.isPresent()) {
			Book book = byId.get();
			return book;
		}
		return null;
	}

	@Override
	public void deleteById(Long id) {

		bookRepository.deleteById(id);

	}

}

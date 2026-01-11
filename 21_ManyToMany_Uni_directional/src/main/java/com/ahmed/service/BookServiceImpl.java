package com.ahmed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.entity.Author;
import com.ahmed.entity.Book;
import com.ahmed.repository.AuthorRepo;
import com.ahmed.repository.BookRepo;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepo bookRepo;

	@Autowired
	AuthorRepo authorRepo;

	@Override
	public Author addBooks(Author author, List<Book> books) {
		author.setBooks(books);
		return author;
	}

	@Override
	public Author saveAuthor(Author author) {
		return authorRepo.save(author);

	}

	@Override
	public Book addAuthors(Book book, List<Author> author) {
		book.setAuthors(author);
		return book;
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public Book loadBook(Long id) {
		return bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book is no found with the id: " + id));

		/*
		 * 1) bookRepo.findById(id)
		 * 
		 * This tries to find a Book by its id.
		 * 
		 * But it does NOT return a Book directly.
		 * 
		 * It returns an Optional<Book>, .orElseThrow(...)
		 * 
		 * This line means:
		 * 
		 * 👉 If the book is inside the Optional → give it to me. 👉 If the Optional is
		 * empty → throw an exception.
		 * 
		 * So it handles both cases:
		 * 
		 * Book exists → returned
		 * 
		 * Book not found → error thrown
		 * 
		 * 3) () -> new RuntimeException("Book not found…")
		 * 
		 * This is a lambda function. Think of it as:
		 * 
		 * "If book not found, create this exception and throw it."
		 * 
		 * The message inside exception helps you know why it failed.
		 */

	}

	@Override
	public Boolean removeBook(Long id) {

		if (bookRepo.existsById(id)) {
			bookRepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}

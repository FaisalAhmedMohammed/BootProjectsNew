package com.ahmed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.entity.Book;
import com.ahmed.exceptions.BookAlreadyExistException;
import com.ahmed.exceptions.BookNotFoundException;
import com.ahmed.repository.BookRepository;

@Service(value = "BookService")
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository repository;

	@Override
	public Book saveBook(Book saveBook) {
		if (!repository.existsById(saveBook.getId())) {
			return repository.save(saveBook);

		} else {
			throw new BookAlreadyExistException("Book with this id : " + saveBook.getId() + " aleady Exist in DB");
		}
	}

	@Override
	public Book fetchBookById(Integer id) {
		if (repository.existsById(id)) {
			return repository.findById(id).get();
		} else {
			throw new BookNotFoundException("Book with id : " + id + " Does not exist in DB");
		}
	}

	@Override
	public List<Book> fetchAll() {
		return repository.findAll();
	}

	@Override
	public void deleteBookById(Integer id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new BookNotFoundException("Book with id : " + id + " Does not exist in DB");
		}

	}

}

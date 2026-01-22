package com.ahmed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ahmed.Exceptions.BookAlreadyExistException;
import com.ahmed.Exceptions.BookNotFoundException;
import com.ahmed.entity.Book;
import com.ahmed.repository.BookRepository;

@Component(value = "BookService")
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository repository;

	@Override
	public Book save(Book saveBook) {
		if (!repository.existsById(saveBook.getId())) {
			return repository.save(saveBook);
		} else {
			throw new BookAlreadyExistException("Book with the given :" + saveBook.getId() + " is alread exist in Db");
		}

	}

	@Override
	public Book fetchBookById(Integer id) {
		if (repository.existsById(id)) {
			return repository.findById(id).get();
		} else {
			throw new BookNotFoundException("Book with id : " + id + " doesn't exist in DB");
		}
	}

	@Override
	public List<Book> fetchAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new BookNotFoundException("Book with id : " + id + "doesn't exist in DB");
		}
	}

}

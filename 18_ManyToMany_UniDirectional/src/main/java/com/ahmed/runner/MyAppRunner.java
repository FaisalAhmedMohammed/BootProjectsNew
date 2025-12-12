package com.ahmed.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ahmed.entity.Authors;
import com.ahmed.entity.Book;
import com.ahmed.service.BookService;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	BookService bookService;

	@Transactional
	@Override
	public void run(ApplicationArguments args) throws Exception {
		addBooks();
	}

	private void addBooks() {

		Book book1 = new Book();
		book1.setName("java");

		Book book2 = new Book();
		book2.setName("spring");

		Authors authors1 = new Authors();
		authors1.setName("JAMES");

		Authors authors2 = new Authors();
		authors2.setName("JONNY");

		Authors authors3 = new Authors();
		authors3.setName("JAFFERY");

		List<Authors> book_author1 = Arrays.asList(authors1, authors3);

		List<Authors> book_author2 = Arrays.asList(authors2, authors3);

		// settings Authors to the Books 
		book1 = bookService.addAuthors(book1, book_author1);
		book2 = bookService.addAuthors(book2, book_author2);

		bookService.saveBook(book1); // saving book1 in db

		bookService.saveBook(book2);  // saving book 2 in db

		System.out.println("Books with Authors inserted in Data Base");
		System.out.println("Id of book 1 is" + book1.getId());
		System.out.println("Id of book 2 is" + book2.getId());
	}
}

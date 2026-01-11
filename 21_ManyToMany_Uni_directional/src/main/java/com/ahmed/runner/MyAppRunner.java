package com.ahmed.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ahmed.entity.Author;
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
		book1.setName("JAVA");

		Book book2 = new Book();
		book2.setName("SPRING BOOT");

		Author author1 = new Author();
		author1.setName("SOPHIA");

		Author author2 = new Author();
		author2.setName("MILLER");

		Author author3 = new Author();
		author3.setName("ALEN");

		List<Author> list1 = Arrays.asList(author1, author3);
		List<Author> list2 = Arrays.asList(author2, author3);

		book1 = bookService.addAuthors(book1, list1);
		book2 = bookService.addAuthors(book2, list2);

		bookService.saveBook(book1);
		bookService.saveBook(book2);

		System.out.println("Inserted Successfully");
		System.out.println("Book1 ID: " + book1.getId());
		System.out.println("Book2 ID: " + book2.getId());

		System.out.println("Directions ");

	}

}

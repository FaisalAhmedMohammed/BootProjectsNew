package com.ahmed.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.entity.Book;
import com.ahmed.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "Book", description = "Book To Perform CRUD Operations")
@RestController(value = "BookController")
public class BookRestController {

	@Autowired
	BookService service;

	@Operation(summary = "Fetch Book", description = "FetchBook From DB With the given ID")
	@GetMapping(value = "/{id}",
				produces = "application/json")
	
	@ApiResponse(responseCode = "200", description = "Book Fetched From DB Sucessfully")
	
	@ApiResponse(responseCode = "404" , description = "Employee with the given id is NOT FOUND")
	
	//@PreAuthorize("hasRole('ADMIN')")// It is method level authorization
	
	public ResponseEntity<Book> getBookById(@PathVariable @Parameter(description = "Id to be fetch from the DB") Integer id) {
		return new ResponseEntity<Book>(service.fetchBookById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/books",
				produces =  MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get Books" , description = "Retrive All the Books From the DB")
	
	public ResponseEntity <List<Book>> getAllBooks(){
		return new ResponseEntity <List <Book>>(service.fetchAll(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/add",
				consumes = "application/json",
				produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Add Book" , description = "ADD Book To DB With the given ID")
	
	public ResponseEntity<Book>saveBook(@RequestBody Book book){
		return new ResponseEntity<Book>(service.save(book),HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}")
	
	@Operation(summary = "Delete Book" , description = "Delete Book From DB With the given ID")
	public ResponseEntity<Void> deleteBookById(@PathVariable @Parameter(description = "ID to Delete the Book From DB" ) Integer id){
		service.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

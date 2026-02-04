package com.ahmed.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.entity.Book;
import com.ahmed.service.BookService;
import com.ahmed.util.JwtUtil;

@RestController(value = "BookController")
public class BookRestController {

	@Autowired
	BookService service;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil jwtUtil;
	
	// when ever the user click on submit button after proverding username and password request is 
	// send to this login post url @RequestBody to decode the username and password.
	//then calling authenticationManager to authenticate the username and password by creating  UsernamePasswordAuthenticationToken object
	//if error then handled if not occured then Authentication object will be returned.
	
	// here by default all this done by filter in spring security that will create the session, so to create jwt we are creating 	
	
	
	// then generate token 
	
	@PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        String token = jwtUtil.generateToken(authRequest.getUsername());
        JwtResponse jwtResp = new JwtResponse(authRequest.getUsername(), token);
        return new ResponseEntity<>(jwtResp, HttpStatus.OK);
    }

	@GetMapping(value = "/{id}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
		return new ResponseEntity<Book>(service.fetchBookById(id), HttpStatus.OK);
	}

	@GetMapping(value = "/books",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book>> getAll() {
		return new ResponseEntity<List<Book>>(service.fetchAll(), HttpStatus.OK);
	}

	@PostMapping(value = "/add",
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(service.saveBook(book), HttpStatus.OK);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteBookById(@PathVariable Integer id) {
		service.deleteBookById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

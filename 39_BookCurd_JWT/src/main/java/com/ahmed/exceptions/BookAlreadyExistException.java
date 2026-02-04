package com.ahmed.exceptions;

public class BookAlreadyExistException extends RuntimeException {

	public BookAlreadyExistException(String msg) {
		super(msg);
	}

}

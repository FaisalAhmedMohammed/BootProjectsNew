package com.ahmed.Exceptions;

public class BookAlreadyExistException extends RuntimeException {

	public BookAlreadyExistException(String msg) {
		super(msg);
	}

}

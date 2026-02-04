package com.ahmed.exceptions;

public class TokenExpiredException extends RuntimeException {
	
	public TokenExpiredException(String msg) {
		
		super(msg);
	}

}

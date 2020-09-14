package com.sample.dl.utils.exception;

public class BookNotFoundException extends RuntimeException {

	public BookNotFoundException(String message) {
		super(message);
	}
	private static final long serialVersionUID = -7034897190745766939L;

}

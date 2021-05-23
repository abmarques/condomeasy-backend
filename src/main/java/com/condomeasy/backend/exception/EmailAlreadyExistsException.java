package com.condomeasy.backend.exception;

public class EmailAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailAlreadyExistsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EmailAlreadyExistsException(String arg0) {
		super(arg0);
	}

}

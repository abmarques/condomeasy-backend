package com.condomeasy.backend.exception;

public class UsernameAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsernameAlreadyExistsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UsernameAlreadyExistsException(String arg0) {
		super(arg0);
	}

}

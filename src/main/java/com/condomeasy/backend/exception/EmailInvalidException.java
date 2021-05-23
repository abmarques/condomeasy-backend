package com.condomeasy.backend.exception;

public class EmailInvalidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailInvalidException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EmailInvalidException(String arg0) {
		super(arg0);
	}

}

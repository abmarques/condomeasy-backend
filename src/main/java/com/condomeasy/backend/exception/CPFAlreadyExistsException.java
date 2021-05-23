package com.condomeasy.backend.exception;

public class CPFAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CPFAlreadyExistsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CPFAlreadyExistsException(String arg0) {
		super(arg0);
	}

}

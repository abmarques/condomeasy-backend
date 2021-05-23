package com.condomeasy.backend.exception;

public class InvalidCPFException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidCPFException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidCPFException(String arg0) {
		super(arg0);
	}

}

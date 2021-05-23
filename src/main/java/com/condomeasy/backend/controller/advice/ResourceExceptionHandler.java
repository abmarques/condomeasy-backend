package com.condomeasy.backend.controller.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.condomeasy.backend.exception.CPFAlreadyExistsException;
import com.condomeasy.backend.exception.EmailAlreadyExistsException;
import com.condomeasy.backend.exception.EmailInvalidException;
import com.condomeasy.backend.exception.InvalidCPFException;
import com.condomeasy.backend.exception.UsernameAlreadyExistsException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<StandardError> emailAlreadyExists(EmailAlreadyExistsException e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.CONFLICT.value(), e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
	}
	
	@ExceptionHandler(UsernameAlreadyExistsException.class)
	public ResponseEntity<StandardError> usernameAlreadyExists(UsernameAlreadyExistsException e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.CONFLICT.value(), e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
	}
	
	@ExceptionHandler(EmailInvalidException.class)
	public ResponseEntity<StandardError> invalidEmail(EmailInvalidException e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(InvalidCPFException.class)
	public ResponseEntity<StandardError> invalidCPF(InvalidCPFException e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.CONFLICT.value(), e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
	}
	
	@ExceptionHandler(CPFAlreadyExistsException.class)
	public ResponseEntity<StandardError> invalidCPF(CPFAlreadyExistsException e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.CONFLICT.value(), e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
	}
}

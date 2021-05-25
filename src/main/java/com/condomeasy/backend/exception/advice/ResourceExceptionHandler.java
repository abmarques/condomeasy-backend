package com.condomeasy.backend.exception.advice;

import javax.servlet.http.HttpServletRequest;

import com.condomeasy.backend.exception.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<StandardError> businessException(BusinessException e, HttpServletRequest request){
		StandardError err = new StandardError(e.getStatus(), LocalDateTime.now(), e.getMessage());
		
		return ResponseEntity.status(e.getStatus()).body(err);
	}

}

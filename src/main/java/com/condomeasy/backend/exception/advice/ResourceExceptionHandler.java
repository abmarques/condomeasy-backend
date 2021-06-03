package com.condomeasy.backend.exception.advice;

import javax.servlet.http.HttpServletRequest;

import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

import static com.condomeasy.backend.constant.MessageBundle.INTERNAL_ERROR;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Response> businessException(BusinessException e, HttpServletRequest request){
		Response response = new Response();

		response.setStatus(e.getStatus());
		response.setMessage(INTERNAL_ERROR);
		response.setDateTime(LocalDateTime.now());
		response.getErrors().add(e.getMessage());

		return ResponseEntity.badRequest().body(response);
	}

}

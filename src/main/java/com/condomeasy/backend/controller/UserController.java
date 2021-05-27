package com.condomeasy.backend.controller;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.condomeasy.backend.controller.base.BaseController;
import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.mapper.UserMapper;
import com.condomeasy.backend.response.Response;
import com.condomeasy.backend.service.IUserService;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {
	
	@Autowired
	private IUserService service;

	@PostMapping
	public ResponseEntity<Response> create(@Valid @RequestBody UserDTO userDto, BindingResult result){
		if (result.hasErrors())	return invalidModelState(result);

		var responseData = service.save(userDto);

		var response = Response.builder()
				.status(HttpStatus.OK.value())
				.dateTime(LocalDateTime.now())
				.data(UserMapper.modelToDtoMap(responseData))
				.build();
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping
	public ResponseEntity<Response> delete(@Valid @RequestBody UserDTO userDto, BindingResult result){
		if (result.hasErrors())	return invalidModelState(result);

		service.delete(userDto);

		var response = Response.builder()
				.status(HttpStatus.OK.value())
				.dateTime(LocalDateTime.now())
				.build();
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Response> update( @PathVariable("id") Integer id,  @Valid @RequestBody UserDTO userDto, BindingResult result){
		if (result.hasErrors())	return invalidModelState(result);

		var responseData = service.update(userDto, id);

		var response = Response.builder()
				.status(HttpStatus.OK.value())
				.dateTime(LocalDateTime.now())
				.data(UserMapper.modelToDtoMap(responseData))
				.build();
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response> findById(@PathVariable Integer id) {
		var responseData = service.findById(id);

		 var response = Response.builder()
				 .status(HttpStatus.OK.value())
				 .dateTime(LocalDateTime.now())
				 .data(UserMapper.modelToDtoMap(responseData))
				 .build();

		return ResponseEntity.ok(response);
	}
	
}

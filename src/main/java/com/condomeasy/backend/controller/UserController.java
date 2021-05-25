package com.condomeasy.backend.controller;

import com.condomeasy.backend.controller.base.BaseController;
import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.mapper.UserMapper;
import com.condomeasy.backend.model.User;
import com.condomeasy.backend.response.Response;
import com.condomeasy.backend.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

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
				.data(responseData)
				.build();
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response> findById(@PathVariable Integer id) {
		var responseData = service.findById(id);

		 var response = Response.builder()
				 .status(HttpStatus.OK.value())
				 .dateTime(LocalDateTime.now())
				 .data(responseData)
				 .build();

		return ResponseEntity.ok(response);
	}
	
}

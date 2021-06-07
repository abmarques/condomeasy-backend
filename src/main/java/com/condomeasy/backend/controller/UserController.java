package com.condomeasy.backend.controller;

import com.condomeasy.backend.controller.base.BaseController;
import com.condomeasy.backend.dto.user.UserCreateDTO;
import com.condomeasy.backend.dto.user.UserUpdateDTO;
import com.condomeasy.backend.dto.user.UserUpdatePasswordDTO;
import com.condomeasy.backend.response.Response;
import com.condomeasy.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

import static com.condomeasy.backend.constant.MessageBundle.TRANSACTION_SUCCESFUL;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {
	
	@Autowired
	private IUserService service;

	@PostMapping
	public ResponseEntity<Response> create(@Valid @RequestBody UserCreateDTO userCreateDTO, BindingResult result){
		if (result.hasErrors())	return invalidModelState(result);

		var responseData = service.save(userCreateDTO);

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

	@GetMapping(value = "/username/{username}")
	public ResponseEntity<Response> findById(@PathVariable String username) {
		var responseData = service.findByUsername(username);

		var response = Response.builder()
				.status(HttpStatus.OK.value())
				.dateTime(LocalDateTime.now())
				.data(responseData)
				.build();

		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response> update(@PathVariable("id") Integer id, @Valid @RequestBody UserUpdateDTO dto, BindingResult result){
		if (result.hasErrors())	return invalidModelState(result);

		var responseData = service.update(id, dto);

		var response = Response.builder()
				.status(HttpStatus.OK.value())
				.dateTime(LocalDateTime.now())
				.data(responseData)
				.build();
		
		return ResponseEntity.ok(response);
	}

	@PutMapping("/password/{id}")
	public ResponseEntity<Response> updatePassword(@PathVariable("id") Integer id, @Valid @RequestBody UserUpdatePasswordDTO dto, BindingResult result){
		if (result.hasErrors())	return invalidModelState(result);

		service.updatePassword(id, dto);

		var response = Response.builder()
				.status(HttpStatus.OK.value())
				.dateTime(LocalDateTime.now())
				.message(TRANSACTION_SUCCESFUL)
				.build();

		return ResponseEntity.ok(response);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Response> delete(@PathVariable("id") Integer id, BindingResult result){
		if (result.hasErrors())	return invalidModelState(result);

		service.delete(id);

		var response = Response.builder()
				.status(HttpStatus.OK.value())
				.dateTime(LocalDateTime.now())
				.message(TRANSACTION_SUCCESFUL)
				.build();

		return ResponseEntity.ok(response);
	}
}

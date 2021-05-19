package com.condomeasy.backend.controller.user;

import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.model.User;
import com.condomeasy.backend.response.Response;
import com.condomeasy.backend.service.user.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<Response<UserDTO>> create(@Valid @RequestBody UserDTO userDto, BindingResult result){
		Response<UserDTO> response = new Response<UserDTO>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		response.setData(this.convertEntityToDto(service.save(this.convertDtoToEntity(userDto))));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<UserDTO>> findById(@PathVariable Integer id) {
		Response<UserDTO> response = new Response<UserDTO>();
		User user = service.findById(id);
		
		response.setData(this.convertEntityToDto(user));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	private UserDTO convertEntityToDto(User usuario) {
		UserDTO dto = new UserDTO();
				
		BeanUtils.copyProperties(usuario, dto);		
	    return dto;
	}
	
	private User convertDtoToEntity(UserDTO postDto) {
		User usuario = new User();
		BeanUtils.copyProperties(postDto, usuario);

	    return usuario;
	}
}

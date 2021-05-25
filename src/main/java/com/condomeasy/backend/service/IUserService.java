package com.condomeasy.backend.service;

import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.model.User;

public interface IUserService {

	UserDTO save(UserDTO u);
	UserDTO findById(Integer id);
	UserDTO findByUsername(String username);
	
}

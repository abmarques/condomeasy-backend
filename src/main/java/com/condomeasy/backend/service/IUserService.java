package com.condomeasy.backend.service;

import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.model.User;

public interface IUserService {

	User save(UserDTO u);
	void delete(UserDTO u);
	User update(UserDTO dto, Integer id);
	User findById(Integer id);
	User findByUsername(String username);
	User findByUsernameAndPassoword(String username, String password);
	
}

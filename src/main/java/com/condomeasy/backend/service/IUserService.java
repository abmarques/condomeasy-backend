package com.condomeasy.backend.service;

import com.condomeasy.backend.dto.user.UserCreateDTO;
import com.condomeasy.backend.dto.user.UserDTO;
import com.condomeasy.backend.dto.user.UserUpdateDTO;
import com.condomeasy.backend.dto.user.UserUpdatePasswordDTO;

public interface IUserService {

	UserDTO save(UserCreateDTO u);
	UserDTO update(Integer id, UserUpdateDTO dto);

	UserDTO findById(Integer id);
	UserDTO findByUsername(String username);
	UserDTO findByCPF(String cpf);
	UserDTO findByEmail(String email);
	UserDTO findByCredentials(String username, String password);


	void delete(Integer id);
	void updatePassword(Integer id, UserUpdatePasswordDTO dto);


}

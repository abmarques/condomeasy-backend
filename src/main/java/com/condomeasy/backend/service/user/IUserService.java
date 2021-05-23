package com.condomeasy.backend.service.user;

import javax.mail.internet.AddressException;

import com.condomeasy.backend.exception.EmailAlreadyExistsException;
import com.condomeasy.backend.exception.InvalidCPFException;
import com.condomeasy.backend.exception.UsernameAlreadyExistsException;
import com.condomeasy.backend.model.User;

public interface IUserService {

	User save(User u) throws AddressException, EmailAlreadyExistsException, UsernameAlreadyExistsException, InvalidCPFException;
	User findById(Integer id);
	User findByUsername(String username);
	
}

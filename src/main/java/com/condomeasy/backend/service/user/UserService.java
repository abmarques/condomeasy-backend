package com.condomeasy.backend.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condomeasy.backend.model.User;
import com.condomeasy.backend.repository.UserRepository;
import com.condomeasy.backend.validation.UserValidation;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserRepository repository;
	@Autowired
	private UserValidation userValidationService;

	@Override
	public User save(User user) {
		user.setCpf(user.getCpf().replaceAll("[^0-9]", ""));
		userValidationService.validateUser(user);
		return repository.save(user);
	}

	@Override
	public User findById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public User findByUsername(String username) {
		return repository.findByUsername(username).get();
	}

}

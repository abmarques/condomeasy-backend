package com.condomeasy.backend.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condomeasy.backend.model.User;
import com.condomeasy.backend.repository.UserRepository;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public User save(User usuario) {
		return repository.save(usuario);
	}

	@Override
	public User findById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}

}

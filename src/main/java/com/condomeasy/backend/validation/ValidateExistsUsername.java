package com.condomeasy.backend.validation;

import com.condomeasy.backend.exception.UsernameAlreadyExistsException;
import com.condomeasy.backend.model.User;
import com.condomeasy.backend.repository.UserRepository;

public class ValidateExistsUsername implements Validation{
	
	private UserRepository userRepository;
	private Validation proximo;

	@Override
	public void validate(User user) {
		if (userRepository.findByUsername(user.getUsername()).isPresent()) {
			throw new UsernameAlreadyExistsException("Usuário já existe.");
		}
		
		proximo.setUserRepository(userRepository);
		proximo.validate(user);
	}
	
	@Override
	public void setProximo(Validation proximo) {
		this.proximo = proximo;
	}

	@Override
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


}

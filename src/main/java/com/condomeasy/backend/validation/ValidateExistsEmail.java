package com.condomeasy.backend.validation;

import com.condomeasy.backend.exception.EmailAlreadyExistsException;
import com.condomeasy.backend.model.User;
import com.condomeasy.backend.repository.UserRepository;

public class ValidateExistsEmail implements Validation{
	
	private UserRepository userRepository;
	private Validation proximo;

	@Override
	public void validate(User user) {
		if (userRepository.findByEmail(user.getEmail()).isPresent()) {
			throw new EmailAlreadyExistsException("Email já existe.");
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

package com.condomeasy.backend.validator.impl;

import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.repository.IUserRepository;
import com.condomeasy.backend.validator.IValidator;

public class ExistsEmailIValidator implements IValidator {
	
	private IUserRepository userRepository;
	private IValidator proximo;

	@Override
	public void validate(UserDTO user) {
		if (userRepository.findByEmail(user.getEmail()).isPresent()) {
			throw new BusinessException("Email já existe.");
		} 
		
		if (proximo != null) {
			proximo.setUserRepository(userRepository);
			proximo.validate(user);
		}
	}

	@Override
	public void setProximo(IValidator proximo) {
		this.proximo = proximo;
	}

	@Override
	public void setUserRepository(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public IValidator getProximo() {
		return this.proximo;
	}

}

package com.condomeasy.backend.validator.impl;

import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.repository.IUserRepository;
import com.condomeasy.backend.validator.IValidator;

public class ExistsEmailIValidator implements IValidator {
	
	private IUserRepository IUserRepository;
	private IValidator proximo;

	@Override
	public void validate(UserDTO user) {
		if (IUserRepository.findByEmail(user.getEmail()).isPresent()) {
			throw new BusinessException("Email já existe.");
		} 
		
		proximo.setUserRepository(IUserRepository);
		proximo.validate(user);
	}

	@Override
	public void setProximo(IValidator proximo) {
		this.proximo = proximo;
	}

	@Override
	public void setUserRepository(IUserRepository IUserRepository) {
		this.IUserRepository = IUserRepository;
	}

}

package com.condomeasy.backend.validator.impl;

import com.condomeasy.backend.dto.user.UserCreateDTO;
import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.repository.IUserRepository;
import com.condomeasy.backend.validator.IValidator;

public class UsernameValidator implements IValidator {
	
	private IUserRepository userRepository;
	private IValidator proximo;

	@Override
	public void validate(UserCreateDTO user) {
		if (userRepository.findByUsername(user.getUsername()).isPresent()) {
			throw new BusinessException("Usuário já existe.");
		}

//		if(!(user.getUsername().matches("^[a-zA-Z][a-zA-Z0-9_-]"))){
//			throw new BusinessException("Usuário inválido.");
//		}

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

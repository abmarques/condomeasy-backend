package com.condomeasy.backend.validator.impl;

import com.condomeasy.backend.dto.user.UserCreateDTO;
import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.repository.IUserRepository;
import com.condomeasy.backend.validator.IValidator;

public class ExistsCPFValidator implements IValidator {

	private IUserRepository userRepository;
	private IValidator proximo;

	@Override
	public void validate(UserCreateDTO user) {
		if (userRepository.findByCpf(user.getCpf()).isPresent()) {
			throw new BusinessException("CPF já existe.");
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
		return null;
	}

}

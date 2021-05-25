package com.condomeasy.backend.validator.impl;

import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.model.User;
import com.condomeasy.backend.repository.UserRepository;
import com.condomeasy.backend.validator.IValidator;

public class ExistsCPFIValidator implements IValidator {

	private UserRepository userRepository;

	@Override
	public void validate(UserDTO user) {
		if (userRepository.findByCpf(user.getCpf()).isPresent()) {
			throw new BusinessException("CPF já existe.");
		}
	}

	@Override
	public void setProximo(IValidator proximo) {
	}

	@Override
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}

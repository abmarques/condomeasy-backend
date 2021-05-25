package com.condomeasy.backend.validator.impl;

import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.repository.IUserRepository;
import com.condomeasy.backend.validator.IValidator;

public class ExistsCPFIValidator implements IValidator {

	private IUserRepository IUserRepository;

	@Override
	public void validate(UserDTO user) {
		if (IUserRepository.findByCpf(user.getCpf()).isPresent()) {
			throw new BusinessException("CPF já existe.");
		}
	}

	@Override
	public void setProximo(IValidator proximo) {
	}

	@Override
	public void setUserRepository(IUserRepository IUserRepository) {
		this.IUserRepository = IUserRepository;
	}

}

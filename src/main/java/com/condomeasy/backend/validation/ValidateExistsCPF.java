package com.condomeasy.backend.validation;

import com.condomeasy.backend.exception.CPFAlreadyExistsException;
import com.condomeasy.backend.model.User;
import com.condomeasy.backend.repository.UserRepository;

public class ValidateExistsCPF implements Validation {

	private UserRepository userRepository;

	@Override
	public void validate(User user) {
		if (userRepository.findByCpf(user.getCpf()).isPresent()) {
			throw new CPFAlreadyExistsException("CPF já existe.");
		}
	}

	@Override
	public void setProximo(Validation proximo) {
	}

	@Override
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}

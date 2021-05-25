package com.condomeasy.backend.validator.impl;

import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.validator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.condomeasy.backend.repository.IUserRepository;

@Service
public class UserValidator {

	@Autowired
	private IUserRepository IUserRepository;

	public boolean validateUser(UserDTO user) {

		final IValidator validateExistsEmail = new ExistsEmailIValidator();
		final IValidator validateEmail = new EmailIValidator();
		final IValidator validateUsername = new ExistsUsernameIValidator();
		final IValidator validateCPF = new CPFIValidator();
		final IValidator validateExistsCPF = new ExistsCPFIValidator();

		validateExistsEmail.setProximo(validateEmail);
		validateExistsEmail.setUserRepository(IUserRepository);
		validateEmail.setProximo(validateUsername);
		validateUsername.setProximo(validateCPF);
		validateCPF.setProximo(validateExistsCPF);

		validateExistsEmail.validate(user);

		return true;
	}
}

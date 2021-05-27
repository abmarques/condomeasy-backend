package com.condomeasy.backend.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.model.User;
import com.condomeasy.backend.repository.IUserRepository;
import com.condomeasy.backend.validator.IValidator;

@Service
public class UserValidator {

	@Autowired
	private IUserRepository userRepository;

	public boolean validateUser(UserDTO user) {

		final IValidator validateExistsEmail = new ExistsEmailIValidator();
		final IValidator validateEmail = new EmailIValidator();
		final IValidator validateUsername = new ExistsUsernameIValidator();
		final IValidator validateCPF = new CPFIValidator();
		final IValidator validateExistsCPF = new ExistsCPFIValidator();

		validateExistsEmail.setProximo(validateEmail);
		validateExistsEmail.setUserRepository(userRepository);
		validateEmail.setProximo(validateUsername);
		validateUsername.setProximo(validateCPF);
		validateCPF.setProximo(validateExistsCPF);

		validateExistsEmail.validate(user);

		return true;
	}
	
	public boolean validateUserUpdate(UserDTO userDTO, User user) {

		final IValidator validator = new Validator();
		final IValidator validateExistsEmail = new ExistsEmailIValidator();
		final IValidator validateUsername = new ExistsUsernameIValidator();
		final IValidator validateCPF = new CPFIValidator();
		final IValidator validateExistsCPF = new ExistsCPFIValidator();

		if(!userDTO.getCpf().equals(user.getCpf())) {
			validator.setProximo(validateExistsCPF);
			validateExistsCPF.setProximo(validateCPF);
		}
		
		if(!userDTO.getEmail().equals(user.getEmail())) {
			if(validator.getProximo() == null) {
				
				validator.setProximo(validateExistsEmail);
			} else {
				
				validator.getProximo().setProximo(validateExistsEmail);
			}
		}
		
		if(!userDTO.getUsername().equals(user.getUsername())) {
			if(validator.getProximo() == null) {
				
				validator.setProximo(validateUsername);
			} else {
				
				validator.getProximo().setProximo(validateUsername);
			}
		}

		return true;
	}
}

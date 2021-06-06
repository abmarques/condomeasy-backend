package com.condomeasy.backend.validator.impl;

import com.condomeasy.backend.dto.user.UserCreateDTO;
import com.condomeasy.backend.dto.user.UserUpdateDTO;
import com.condomeasy.backend.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condomeasy.backend.model.User;
import com.condomeasy.backend.repository.IUserRepository;
import com.condomeasy.backend.validator.IValidator;

@Service
public class UserValidator {

	@Autowired
	private IUserRepository userRepository;

	public boolean validateUserCreate(UserCreateDTO user) throws BusinessException {

		final IValidator validateExistsEmail = new ExistsEmailValidator();
		final IValidator validateEmail = new EmailValidator();
		final IValidator validateUsername = new UsernameValidator();
		final IValidator validateCPF = new CPFValidator();
		final IValidator validateExistsCPF = new ExistsCPFValidator();

		validateExistsEmail.setProximo(validateEmail);
		validateExistsEmail.setUserRepository(userRepository);
		validateEmail.setProximo(validateUsername);
		validateUsername.setProximo(validateCPF);
		validateCPF.setProximo(validateExistsCPF);

		validateExistsEmail.validate(user);

		return true;
	}
	
	public boolean validateUserUpdate(UserUpdateDTO userDTO, User user) throws BusinessException {

		final IValidator validator = new Validator();
		final IValidator validateExistsEmail = new ExistsEmailValidator();
		final IValidator validateUsername = new UsernameValidator();
		final IValidator validateCPF = new CPFValidator();
		final IValidator validateExistsCPF = new ExistsCPFValidator();

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

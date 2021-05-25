package com.condomeasy.backend.validator.impl;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.model.User;
import com.condomeasy.backend.repository.UserRepository;
import com.condomeasy.backend.validator.IValidator;

public class EmailIValidator implements IValidator {
	
	private UserRepository userRepository;
	private IValidator proximo;

	@Override
	public void validate(UserDTO user) {
		try {
			InternetAddress emailAddr = new InternetAddress(user.getEmail());
			emailAddr.validate();
		} catch (AddressException e) {
			throw new BusinessException("Email inválido");
		}
		
		proximo.setUserRepository(userRepository);
		proximo.validate(user);
	}

	@Override
	public void setProximo(IValidator proximo) {
		this.proximo = proximo;
	}

	@Override
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}

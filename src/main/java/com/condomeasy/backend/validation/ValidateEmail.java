package com.condomeasy.backend.validation;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.condomeasy.backend.exception.EmailInvalidException;
import com.condomeasy.backend.model.User;
import com.condomeasy.backend.repository.UserRepository;

public class ValidateEmail implements Validation{
	
	private UserRepository userRepository;
	private Validation proximo;

	@Override
	public void validate(User user) {
		try {
			InternetAddress emailAddr = new InternetAddress(user.getEmail());
			emailAddr.validate();
		} catch (AddressException e) {
			throw new EmailInvalidException("Email inválido");
		}
		
		proximo.setUserRepository(userRepository);
		proximo.validate(user);
	}

	@Override
	public void setProximo(Validation proximo) {
		this.proximo = proximo;
	}

	@Override
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}

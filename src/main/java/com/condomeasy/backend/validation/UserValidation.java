package com.condomeasy.backend.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.condomeasy.backend.model.User;
import com.condomeasy.backend.repository.UserRepository;

@Service
public class UserValidation {

	@Autowired
	private UserRepository userRepository;

	public boolean validateUser(User user) {

		final Validation validateExistsEmail = new ValidateExistsEmail();
		final Validation validateEmail = new ValidateEmail();
		final Validation validateUsername = new ValidateExistsUsername();
		final Validation validateCPF = new ValidateCPF();
		final Validation validateExistsCPF = new ValidateExistsCPF();

		validateExistsEmail.setProximo(validateEmail);
		validateExistsEmail.setUserRepository(userRepository);
		validateEmail.setProximo(validateUsername);
		validateUsername.setProximo(validateCPF);
		validateCPF.setProximo(validateExistsCPF);

		validateExistsEmail.validate(user);

		return true;
	}
}

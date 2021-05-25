package com.condomeasy.backend.validator;

import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.model.User;
import com.condomeasy.backend.repository.UserRepository;

public interface IValidator {
	 
    void validate(UserDTO user);
    
    void setUserRepository(UserRepository userRepository);
 
    void setProximo(IValidator proximo);
}

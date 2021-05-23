package com.condomeasy.backend.validation;

import com.condomeasy.backend.model.User;
import com.condomeasy.backend.repository.UserRepository;

interface Validation {
	 
    void validate(User user);
    
    void setUserRepository(UserRepository userRepository);
 
    void setProximo(Validation proximo);
}

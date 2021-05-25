package com.condomeasy.backend.validator;

import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.repository.IUserRepository;

public interface IValidator {
	 
    void validate(UserDTO user);
    
    void setUserRepository(IUserRepository IUserRepository);
 
    void setProximo(IValidator proximo);
}

package com.condomeasy.backend.validator;

import com.condomeasy.backend.dto.user.UserCreateDTO;
import com.condomeasy.backend.dto.user.UserDTO;
import com.condomeasy.backend.repository.IUserRepository;

public interface IValidator {
	 
    void validate(UserCreateDTO dto);
    
    void setUserRepository(IUserRepository IUserRepository);
 
    IValidator getProximo();
    
    void setProximo(IValidator proximo);
}

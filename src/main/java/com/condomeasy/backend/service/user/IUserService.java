package com.condomeasy.backend.service.user;

import com.condomeasy.backend.model.User;

public interface IUserService {

	User save(User u);
	User findById(Integer id);
	
}

package com.condomeasy.backend.service.impl;

import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.mapper.UserMapper;
import com.condomeasy.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.condomeasy.backend.model.User;
import com.condomeasy.backend.repository.UserRepository;
import com.condomeasy.backend.validator.impl.UserValidator;

import static com.condomeasy.backend.constants.MessageBundle.EMPTY_DATA;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository repository;

	@Autowired
	private UserValidator userValidatorService;

	@Override
	public UserDTO save(UserDTO dto) throws BusinessException{
		dto.setCpf(dto.getCpf().replaceAll("[^0-9]", ""));
		userValidatorService.validateUser(dto);

		var model = repository.save(UserMapper.dtoToModelMap(dto));

		return UserMapper.modelToDtoMap(model);
	}

	@Override
	public UserDTO findById(Integer id) {
		var model = repository.findById(id);

		if(model.isEmpty()) throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());

		return UserMapper.modelToDtoMap(model.get());
	}

	@Override
	public UserDTO findByUsername(String username) {
		var model = repository.findByUsername(username);

		if(model.isEmpty()) throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());

		return UserMapper.modelToDtoMap(model.get());
	}

}

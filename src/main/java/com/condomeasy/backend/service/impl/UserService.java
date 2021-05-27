package com.condomeasy.backend.service.impl;

import static com.condomeasy.backend.constant.MessageBundle.EMPTY_DATA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.mapper.UserMapper;
import com.condomeasy.backend.model.User;
import com.condomeasy.backend.repository.IUserRepository;
import com.condomeasy.backend.service.IUserService;
import com.condomeasy.backend.validator.impl.UserValidator;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository repository;

	@Autowired
	private UserValidator userValidatorService;

	@Override
	public User save(UserDTO dto) throws BusinessException {
		dto.setCpf(dto.getCpf().replaceAll("[^0-9]", ""));
		userValidatorService.validateUser(dto);

		return repository.save(UserMapper.dtoToModelMap(dto));
	}

	@Override
	public User findById(Integer id) {
		var model = repository.findById(id);

		if (model.isEmpty())
			throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());

		return model.get();
	}

	@Override
	public User findByUsername(String username) {
		var model = repository.findByUsername(username);

		if (model.isEmpty())
			throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());

		return model.get();
	}

	@Override
	public User update(UserDTO dto, Integer id) {
		var data = repository.findById(id);

		if (data.isEmpty())
			throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());
		
		dto.setCpf(dto.getCpf().replaceAll("[^0-9]", ""));
		dto.setId(data.get().getId());
		
		userValidatorService.validateUserUpdate(dto, data.get());
		
		System.out.println(dto.getCpf());
		System.out.println(data.get().getCpf());

		return repository.save(UserMapper.dtoToModelMap(dto));
	}

	@Override
	public void delete(UserDTO dto) {

		repository.delete(UserMapper.dtoToModelMap(dto));
	}

}

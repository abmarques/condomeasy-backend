package com.condomeasy.backend.service.impl;

import com.condomeasy.backend.dto.user.UserCreateDTO;
import com.condomeasy.backend.dto.user.UserDTO;
import com.condomeasy.backend.dto.user.UserUpdateDTO;
import com.condomeasy.backend.dto.user.UserUpdatePasswordDTO;
import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.mapper.UserMapper;
import com.condomeasy.backend.repository.IUserRepository;
import com.condomeasy.backend.service.IUserService;
import com.condomeasy.backend.validator.CheckUserUpdateValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.condomeasy.backend.constant.MessageBundle.EMPTY_DATA;
import static com.condomeasy.backend.constant.MessageBundle.INVALID_CREDENTIALS;

@Slf4j
@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private CheckUserUpdateValidator updateValidator;

	@Override
	public UserDTO save(UserCreateDTO dto) throws BusinessException {

		dto.setCpf(dto.getCpf().replaceAll("[^0-9]", ""));
		dto.setRegistrationDate(LocalDateTime.now());
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));

		var model = repository.save(UserMapper.createDtoToModelMap(dto));

		log.info("User '{}' saved successfully.", model.getId());

		return UserMapper.modelToDtoMap(model);
	}

	@Override
	public UserDTO findById(Integer id) throws BusinessException {

		var model = repository.findById(id);
		if (model.isEmpty()) {
			throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());
		}

		return UserMapper.modelToDtoMap(model.get());
	}

	@Override
	public UserDTO findByUsername(String username) throws BusinessException {

		var model = repository.findByUsername(username);
		if (model.isEmpty()) {
			throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());
		}

		return UserMapper.modelToDtoMap(model.get());
	}

	@Override
	public UserDTO findByCredentials(String username, String password) throws BusinessException {

		var model = repository.findByUsername(username);
		if(model.isEmpty()) {
			throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());
		}

		if (!passwordEncoder.matches(password, model.get().getPassword())){
			throw new BusinessException(INVALID_CREDENTIALS, HttpStatus.BAD_REQUEST.value());
		}

		return UserMapper.modelToDtoMap(model.get());
	}

	@Override
	public UserDTO findByCPF(String cpf) throws BusinessException {
		var model = repository.findByCpf(cpf);
		if (model.isEmpty()){
			throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());
		}

		return UserMapper.modelToDtoMap(model.get());
	}

	@Override
	public UserDTO findByEmail(String email) throws BusinessException {
		var model = repository.findByEmail(email);

		if (model.isEmpty()){
			throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());
		}

		return UserMapper.modelToDtoMap(model.get());
	}

	@Override
	public UserDTO update(Integer id, UserUpdateDTO dto) throws BusinessException {

		var data = repository.findById(id);
		if (data.isEmpty()) {
			throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());
		}

		updateValidator.isValidUpdate(id, dto);

		dto.setLastUpdateDate(LocalDateTime.now());
		dto.setId(data.get().getId());

		var model = repository.save(UserMapper.updateDtoToModelMap(dto));

		log.info("User '{}' updated successfully.", model.getId());

		return UserMapper.modelToDtoMap(model);
	}

	@Override
	public void updatePassword(Integer id, UserUpdatePasswordDTO dto) throws BusinessException {

		var model = repository.findById(id);
		if(model.isEmpty()) {
			throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());
		}

		if (!passwordEncoder.matches(dto.getOldPassword(), model.get().getPassword())){
			throw new BusinessException(INVALID_CREDENTIALS, HttpStatus.BAD_REQUEST.value());
		}

		if (passwordEncoder.matches(dto.getNewPassword(), model.get().getPassword())){
			throw new BusinessException("A senha nova não pode ser igual a antiga.", HttpStatus.BAD_REQUEST.value());
		}

		dto.setNewPassword(passwordEncoder.encode(dto.getNewPassword()));
		repository.updatePassword(dto.getNewPassword(), id);

		log.info("Password updated successfully.");
	}


	@Override
	public void delete(Integer id) throws BusinessException {

		var data = repository.findById(id);
		if (data.isEmpty()) {
			throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());
		}

		repository.delete(data.get());
		log.info(String.format("User '%d' deleted successfully.", data.get().getId()));
	}

}

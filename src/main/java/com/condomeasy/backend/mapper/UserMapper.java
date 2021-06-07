package com.condomeasy.backend.mapper;

import com.condomeasy.backend.dto.user.UserCreateDTO;
import com.condomeasy.backend.dto.user.UserDTO;
import com.condomeasy.backend.dto.user.UserUpdateDTO;
import com.condomeasy.backend.model.User;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

	public static User dtoToModelMap(UserDTO dto) {
		User model = new User();

		BeanUtils.copyProperties(dto, model);

		model.getCondominium().setId(dto.getCondominiumId());
		model.getProfile().setId(dto.getProfileId());

		return model;
	}

	public static UserDTO modelToDtoMap(User model) {
		UserDTO dto = new UserDTO();

		BeanUtils.copyProperties(model, dto);

		dto.setCondominiumId(model.getCondominium().getId());
		dto.setProfileId(model.getProfile().getId());
		dto.setProfileName(model.getProfile().getName());

		return dto;
	}

	public static User createDtoToModelMap(UserCreateDTO createDTO) {
		User model = new User();

		BeanUtils.copyProperties(createDTO, model);

		model.getCondominium().setId(createDTO.getCondominiumId());
		model.getProfile().setId(createDTO.getProfileId());

		return model;
	}

	public static User updateDtoToModelMap(UserUpdateDTO updateDTO) {

		User model = new User();

		BeanUtils.copyProperties(updateDTO, model);
		model.getCondominium().setId(updateDTO.getCondominiumId());
		model.getProfile().setId(updateDTO.getProfileId());

		return model;
	}

	public static List<UserDTO> modelListToDtoListMap(List<User> modelList) {
		List<UserDTO> dtoList = new ArrayList<>();

		for (User model : modelList) {
			dtoList.add(modelToDtoMap(model));
		}
		return dtoList;
	}

}

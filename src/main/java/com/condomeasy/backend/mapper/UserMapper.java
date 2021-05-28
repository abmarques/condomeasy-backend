package com.condomeasy.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.model.User;

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
		dto.setProfileId(model.getCondominium().getId());

		return dto;
	}

	public static List<UserDTO> modelListToDtoList(List<User> modelList) {
		List<UserDTO> dtoList = new ArrayList<>();

		for (User model : modelList) {
			dtoList.add(modelToDtoMap(model));
		}
		return dtoList;
	}

}

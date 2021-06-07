package com.condomeasy.backend.mapper;

import com.condomeasy.backend.dto.ProfileDTO;
import com.condomeasy.backend.model.Profile;
import org.springframework.beans.BeanUtils;

public class ProfileMapper {

    public static ProfileDTO modelToDtoMap(Profile model) {

        ProfileDTO dto = new ProfileDTO();

        BeanUtils.copyProperties(model, dto);

        return dto;
    }

    public static Profile dtoToModelMap(ProfileDTO dto) {

        Profile model = new Profile();

        BeanUtils.copyProperties(dto, model);

        return model;
    }
}

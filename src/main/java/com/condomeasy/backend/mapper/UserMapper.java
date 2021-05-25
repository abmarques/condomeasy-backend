package com.condomeasy.backend.mapper;

import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static User dtoToModelMap(UserDTO dto) {

        var model = User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .surname(dto.getSurname())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .cpf(dto.getCpf())
                .telephone(dto.getTelephone())
                .email(dto.getEmail())
                .apartmentNumber(dto.getApartmentNumber())
                .apartmentBlock(dto.getApartmentBlock())
                .registrationDate(dto.getRegistrationDate())
                .lastUpdateDate(dto.getLastUpdateDate())
                .profile(dto.getProfile())
                .condominium(dto.getCondominium())
                .build();

        return model;
    }

    public static UserDTO modelToDtoMap(User model) {

        var dto = UserDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .surname(model.getSurname())
                .username(model.getUsername())
                .password(model.getPassword())
                .cpf(model.getCpf())
                .telephone(model.getTelephone())
                .email(model.getEmail())
                .apartmentNumber(model.getApartmentNumber())
                .apartmentBlock(model.getApartmentBlock())
                .registrationDate(model.getRegistrationDate())
                .lastUpdateDate(model.getLastUpdateDate())
                .profile(model.getProfile())
                .condominium(model.getCondominium())
                .build();

        return dto;
    }

    public static List<UserDTO> modelListToDtoList(List<User> modelList) {
        List<UserDTO> dtoList = new ArrayList<>();

        for(User model : modelList) {
            dtoList.add(modelToDtoMap(model));
        }
        return dtoList;
    }

}

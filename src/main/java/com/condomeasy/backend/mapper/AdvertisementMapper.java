package com.condomeasy.backend.mapper;

import com.condomeasy.backend.dto.AdvertisementDTO;
import com.condomeasy.backend.model.Advertisement;
import com.condomeasy.backend.model.User;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementMapper {

    public static Advertisement dtoToModelMap(AdvertisementDTO dto) {

        var model = Advertisement.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .value(dto.getValue())
                .category(dto.getCategory())
                .user(User.builder()
                        .id(dto.getUserId())
                        .build())
                .build();

        return model;
    }

    public static AdvertisementDTO modelToDtoMap(Advertisement model) {

        var dto =  AdvertisementDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .description(model.getDescription())
                .value(model.getValue())
                .category(model.getCategory())
                .userId(model.getUser().getId())
                .build();

        return dto;
    }

    public static List<AdvertisementDTO> modelListToDtoListMap(List<Advertisement> modelList) {

        List<AdvertisementDTO> dtoList = new ArrayList<>();

        for(Advertisement model : modelList) {
            dtoList.add(modelToDtoMap(model));
        }

        return dtoList;
    }

}

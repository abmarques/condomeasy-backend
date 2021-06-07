package com.condomeasy.backend.mapper;

import com.condomeasy.backend.dto.AdvertisementDTO;
import com.condomeasy.backend.model.Advertisement;
import com.condomeasy.backend.model.User;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementMapper {

    public static Advertisement dtoToModelMap(AdvertisementDTO dto) {

        Advertisement model = new Advertisement();

        BeanUtils.copyProperties(dto, model);
        model.getUser().setId(dto.getUser().getId());
        model.getCategory().setId(dto.getCategory().getId());

        return model;
    }

    public static AdvertisementDTO modelToDtoMap(Advertisement model) {

        AdvertisementDTO dto = new AdvertisementDTO();

        BeanUtils.copyProperties(model, dto);
        dto.setCategory(CategoryMapper.modelToDtoMap(model.getCategory()));
        dto.setUser(UserMapper.modelToDtoMap(model.getUser()));

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

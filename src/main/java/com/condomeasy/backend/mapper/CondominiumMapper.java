package com.condomeasy.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.condomeasy.backend.dto.CondominiumDTO;
import com.condomeasy.backend.model.Condominium;

public class CondominiumMapper {

    public static Condominium dtoToModelMap(CondominiumDTO dto) {

    	Condominium model = new Condominium();

		BeanUtils.copyProperties(dto, model);

		return model;
    }

    public static CondominiumDTO modelToDtoMap(Condominium model) {

    	CondominiumDTO dto = new CondominiumDTO();

		BeanUtils.copyProperties(model, dto);

		return dto;
    }

    public static List<CondominiumDTO> modelListToDtoListMap(List<Condominium> modelList) {
        List<CondominiumDTO> dtoList = new ArrayList<>();
        for(Condominium model : modelList) {
            dtoList.add(modelToDtoMap(model));
        }
        return dtoList;
    }

}

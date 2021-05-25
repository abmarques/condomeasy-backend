package com.condomeasy.backend.mapper;

import com.condomeasy.backend.dto.CondominiumDTO;
import com.condomeasy.backend.model.Condominium;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class CondominiumMapper {

    public static Condominium dtoToModelMap(CondominiumDTO dto) {

        return Condominium.builder()
                .id(dto.getId())
                .name(dto.getName())
                .cnpj(dto.getCnpj())
                .adress(dto.getAdress())
                .complement(dto.getComplement())
                .number(dto.getNumber())
                .neighborhood(dto.getNeighborhood())
                .city(dto.getCity())
                .uf(dto.getUf())
                .localizationX(dto.getLocalizationX())
                .localizationY(dto.getLocalizationY())
                .build();
    }

    public static CondominiumDTO modelToDtoMap(Condominium model) {

        return CondominiumDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .cnpj(model.getCnpj())
                .adress(model.getAdress())
                .complement(model.getComplement())
                .number(model.getNumber())
                .neighborhood(model.getNeighborhood())
                .city(model.getCity())
                .uf(model.getUf())
                .localizationX(model.getLocalizationX())
                .localizationY(model.getLocalizationY())
                .build();
    }

    public static List<CondominiumDTO> modelListToDtoListMap(List<Condominium> modelList) {
        List<CondominiumDTO> dtoList = new ArrayList<>();
        for(Condominium model : modelList) {
            dtoList.add(modelToDtoMap(model));
        }
        return dtoList;
    }

}

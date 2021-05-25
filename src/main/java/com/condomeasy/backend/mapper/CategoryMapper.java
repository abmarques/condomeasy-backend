package com.condomeasy.backend.mapper;

import com.condomeasy.backend.dto.CategoryDTO;
import com.condomeasy.backend.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    public static Category dtoToModelMap(CategoryDTO dto) {

        var model = Category.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();

        return model;
    }

    public static CategoryDTO modelToDtoMap(Category model) {

        var dto = CategoryDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .build();

        return dto;
    }

    public static List<CategoryDTO> modelListToDtoListMap(List<Category> modelList) {

        List<CategoryDTO> dtoList = new ArrayList<>();

        for(Category model : modelList) {
            dtoList.add(modelToDtoMap(model));
        }

        return dtoList;
    }

}

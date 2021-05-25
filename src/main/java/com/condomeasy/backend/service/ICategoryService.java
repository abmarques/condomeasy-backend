package com.condomeasy.backend.service;

import com.condomeasy.backend.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> findAll();
    CategoryDTO save(CategoryDTO dto);
    CategoryDTO findById(Integer id);
    CategoryDTO update(CategoryDTO dto, Integer id);
    void delete(Integer id);

}

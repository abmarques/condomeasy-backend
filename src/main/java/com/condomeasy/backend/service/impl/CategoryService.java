package com.condomeasy.backend.service.impl;

import com.condomeasy.backend.dto.CategoryDTO;
import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.mapper.CategoryMapper;
import com.condomeasy.backend.repository.ICategoryRepository;
import com.condomeasy.backend.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.condomeasy.backend.constant.MessageBundle.EMPTY_DATA;
import static com.condomeasy.backend.constant.MessageBundle.INTERNAL_ERROR;

@Slf4j
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository repository;

    @Override
    public List<CategoryDTO> findAll() throws BusinessException {

        var modelList = repository.findAll();

        if(modelList.isEmpty()){
            return new ArrayList<>();
        }

        return CategoryMapper.modelListToDtoListMap(modelList);
    }

    @Override
    public CategoryDTO save(CategoryDTO dto) throws BusinessException {

        var model = repository.save(CategoryMapper.dtoToModelMap(dto));

        log.info(String.format("Category '%s' saved successfully.", model.getName()));

        return CategoryMapper.modelToDtoMap(model);
    }

    @Override
    public CategoryDTO findById(Integer id) {

        var model = repository.findById(id);

        if(model.isEmpty()) {
            throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());
        }

        return CategoryMapper.modelToDtoMap(model.get());
    }

    @Override
    public CategoryDTO update(CategoryDTO dto, Integer id) {

        var data = repository.findById(id);

        if(data.isEmpty()) {
            throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());
        }

        dto.setId(data.get().getId());
        var model = repository.save(CategoryMapper.dtoToModelMap(dto));

        log.info(String.format("Category '%s' updated successfully.", model.getName()));

        return CategoryMapper.modelToDtoMap(model);
    }

    @Override
    public void delete(Integer id) {
        var data = repository.findById(id);

        if(data.isEmpty()) {
            throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());
        }

        repository.delete(data.get());

        log.info(String.format("Category '%s' updated successfully.", data.get().getName()));
    }
}

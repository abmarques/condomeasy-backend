package com.condomeasy.backend.service.impl;

import com.condomeasy.backend.dto.CondominiumDTO;
import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.mapper.CondominiumMapper;
import com.condomeasy.backend.model.Condominium;
import com.condomeasy.backend.repository.CondominiumRepository;
import com.condomeasy.backend.service.ICondominiumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Slf4j
@Service
public class CondominiumService implements ICondominiumService {

    @Autowired
    private CondominiumRepository repository;

    @Override
    public List<CondominiumDTO> getAll() throws BusinessException {
        var modelList=  repository.findAll();
        if (modelList.isEmpty()) throw new BusinessException("EMPTY_DATA", HttpStatus.NOT_FOUND.value());

        return CondominiumMapper.modelListToDtoListMap(modelList);
    }

    @Override
    public CondominiumDTO save(CondominiumDTO dto) throws BusinessException{
        var model = repository.save(CondominiumMapper.dtoToModelMap(dto));

        log.info(String.format("Condominium '%s' saved successfully.", model.getName()));

        return CondominiumMapper.modelToDtoMap(model);
    }

    @Override
    public CondominiumDTO findById(Integer id) throws BusinessException{
        var model = repository.findById(id).get();
        if(model == null) throw new BusinessException("EMPTY_DATA", HttpStatus.NOT_FOUND.value());

        return CondominiumMapper.modelToDtoMap(model);
    }

    @Override
    public CondominiumDTO findByName(String name) throws BusinessException{
       var model = (repository.findByName(name));
       if (model == null) throw new BusinessException("EMPTY_DATA", HttpStatus.NOT_FOUND.value());

       return CondominiumMapper.modelToDtoMap(model);
    }

    @Override
    public CondominiumDTO update(CondominiumDTO dto, Integer id) throws BusinessException{
        var data = findById(id);
        if(data == null) throw new BusinessException("EMPTY_DATA", HttpStatus.NOT_FOUND.value());

        dto.setId(data.getId());
        var model = repository.save(CondominiumMapper.dtoToModelMap(dto));

        log.info(String.format("Condominium '%s' updated successfully.", model.getName()));

        return CondominiumMapper.modelToDtoMap(model);
    }

    @Override
    public void delete(Integer id) throws BusinessException{
        var dto = repository.findById(id);
        if (dto.isEmpty()) throw new BusinessException("EMPTY_DATA", HttpStatus.NOT_FOUND.value());

        repository.delete(dto.get());

        log.info(String.format("Condominium '%s' deleted successfully.", dto.get().getName()));
    }
}

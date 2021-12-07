package com.condomeasy.backend.service.impl;

import com.condomeasy.backend.dto.CondominiumDTO;
import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.mapper.CondominiumMapper;
import com.condomeasy.backend.repository.ICondominiumRepository;
import com.condomeasy.backend.service.ICondominiumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.condomeasy.backend.constant.MessageBundle.*;

@Slf4j
@Service
public class CondominiumService implements ICondominiumService {

    @Autowired
    private ICondominiumRepository repository;

    @Override
    public List<CondominiumDTO> findAll() throws BusinessException {
        var modelList=  repository.findAll();

        if (modelList.isEmpty()){
            return new ArrayList<>();
        }

        return CondominiumMapper.modelListToDtoListMap(modelList);
    }

    @Override
    public CondominiumDTO save(CondominiumDTO dto) throws BusinessException{
        var model = repository.save(CondominiumMapper.dtoToModelMap(dto));

        if(model == null)
            throw new BusinessException(INTERNAL_ERROR);

        log.info(String.format("Condominium '%s' saved successfully.", model.getName()));

        return CondominiumMapper.modelToDtoMap(model);
    }

    @Override
    public CondominiumDTO findById(Integer id) throws BusinessException{
        var model = repository.findById(id);

        if(model.isEmpty())
            throw new BusinessException(INVALID_CONDOMINIUM, HttpStatus.NOT_FOUND.value());

        return CondominiumMapper.modelToDtoMap(model.get());
    }

    @Override
    public CondominiumDTO findByName(String name) throws BusinessException{
       var model = repository.findByName(name);

       if (model.isEmpty())
           throw new BusinessException(INVALID_CONDOMINIUM, HttpStatus.NOT_FOUND.value());

       return CondominiumMapper.modelToDtoMap(model.get());
    }

    @Override
    public CondominiumDTO update(CondominiumDTO dto, Integer id) throws BusinessException{
        var data = repository.findById(id);

        if(data.isEmpty())
            throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());

        dto.setId(data.get().getId());
        var model = repository.save(CondominiumMapper.dtoToModelMap(dto));

        log.info(String.format("Condominium '%s' updated successfully.", model.getName()));

        return CondominiumMapper.modelToDtoMap(model);
    }

    @Override
    public void delete(Integer id) throws BusinessException{
        var data = repository.findById(id);

        if (data.isEmpty())
            throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());

        repository.delete(data.get());

        log.info(String.format("Condominium '%s' deleted successfully.", data.get().getName()));
    }
}

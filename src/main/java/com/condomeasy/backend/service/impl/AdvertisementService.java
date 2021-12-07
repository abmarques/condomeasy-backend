package com.condomeasy.backend.service.impl;

import com.condomeasy.backend.dto.AdvertisementDTO;
import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.mapper.AdvertisementMapper;
import com.condomeasy.backend.repository.IAdvertisementRepository;
import com.condomeasy.backend.repository.IUserRepository;
import com.condomeasy.backend.service.IAdvertisementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.condomeasy.backend.constant.MessageBundle.*;

@Slf4j
@Service
public class AdvertisementService implements IAdvertisementService {

    @Autowired
    private IAdvertisementRepository repository;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<AdvertisementDTO> findAll() throws BusinessException {

        var modelList = repository.findAll();

        if (modelList.isEmpty()) {
            return new ArrayList<>();
        }

        return AdvertisementMapper.modelListToDtoListMap(modelList);
    }

    @Override
    public AdvertisementDTO findById(Integer id) throws BusinessException{

        var model = repository.findById(id);

        if (model.isEmpty()){
            throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());
        }

       return AdvertisementMapper.modelToDtoMap(model.get());
    }

    @Override
    public AdvertisementDTO save(AdvertisementDTO dto) throws BusinessException {

        var existsUser = userRepository.findById(dto.getUser().getId());
        if(existsUser.isEmpty()){
            throw new BusinessException(INVALID_USER, HttpStatus.BAD_REQUEST.value());
        }

        var model = repository.save(AdvertisementMapper.dtoToModelMap(dto));

        return AdvertisementMapper.modelToDtoMap(model);
    }

    @Override
    public AdvertisementDTO update(AdvertisementDTO dto, Integer id) throws BusinessException {

        var existsUser = userRepository.findById(dto.getUser().getId());
        if(existsUser.isEmpty()){
            throw new BusinessException(INVALID_USER, HttpStatus.BAD_REQUEST.value());
        }

        var data = repository.findById(id);

        if (data.isEmpty()){
            throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());
        }

        dto.setId(data.get().getId());
        var model = repository.save(AdvertisementMapper.dtoToModelMap(dto));

        log.info(String.format("Advertisement '%s' updated successfully.", model.getName()));

        return AdvertisementMapper.modelToDtoMap(model);
    }

    @Override
    public void delete(Integer id) throws BusinessException {

        var data = repository.findById(id);

        if (data.isEmpty()){
            throw new BusinessException(EMPTY_DATA, HttpStatus.NOT_FOUND.value());
        }

        repository.delete(data.get());

        log.info(String.format("Advertisement '%s' deleted successfully.", data.get().getName()));
    }

}

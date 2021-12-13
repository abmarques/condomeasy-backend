package com.condomeasy.backend.service;

import com.condomeasy.backend.dto.AdvertisementDTO;

import java.util.List;

public interface IAdvertisementService {

    List<AdvertisementDTO> findAll();
    AdvertisementDTO findById(Integer id);
    List<AdvertisementDTO> findByCategoriaId(Integer id);
    AdvertisementDTO save(AdvertisementDTO dto);
    AdvertisementDTO update(AdvertisementDTO dto, Integer id);
    void delete(Integer c);

}

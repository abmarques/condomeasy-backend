package com.condomeasy.backend.service.advertisement;

import com.condomeasy.backend.dto.advertisement.AdvertisementDTO;
import com.condomeasy.backend.model.Advertisement;

import java.util.List;

public interface IAdvertisementService {

    List<AdvertisementDTO> getAll();
    AdvertisementDTO findById(Integer id);
    AdvertisementDTO create(AdvertisementDTO dto);
    AdvertisementDTO update(AdvertisementDTO dto, Integer id);
    void delete(Integer c);

}

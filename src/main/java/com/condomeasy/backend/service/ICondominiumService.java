package com.condomeasy.backend.service;

import com.condomeasy.backend.dto.CondominiumDTO;

import java.util.List;

public interface ICondominiumService {

    List<CondominiumDTO> findAll();
    CondominiumDTO save(CondominiumDTO c);
    CondominiumDTO update(CondominiumDTO c, Integer id);
    void delete(Integer c);
    CondominiumDTO findById(Integer id);
    CondominiumDTO findByName(String Name);

}

package com.condomeasy.backend.service.condominium;

import com.condomeasy.backend.dto.condominium.CondominiumDTO;
import com.condomeasy.backend.model.Condominium;

import java.util.List;

public interface ICondominiumService {

    List<CondominiumDTO> getAll();
    CondominiumDTO save(CondominiumDTO c);
    CondominiumDTO update(CondominiumDTO c, Integer id);
    void delete(Integer c);
    CondominiumDTO findById(Integer id);
    CondominiumDTO findByName(String Name);

}

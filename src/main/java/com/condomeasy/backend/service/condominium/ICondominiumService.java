package com.condomeasy.backend.service.condominium;

import com.condomeasy.backend.model.Condominium;

import java.util.List;

public interface ICondominiumService {

    List<Condominium> getAll();
    Condominium save(Condominium c);
    Condominium update(Condominium c, Integer id);
    void delete(Integer c);
    Condominium findById(Integer id);

}

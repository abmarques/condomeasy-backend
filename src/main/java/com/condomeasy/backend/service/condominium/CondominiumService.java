package com.condomeasy.backend.service.condominium;

import com.condomeasy.backend.dto.condominium.CondominiumDTO;
import com.condomeasy.backend.mapper.CondominiumMapper;
import com.condomeasy.backend.model.Condominium;
import com.condomeasy.backend.repository.CondominiumRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Slf4j
@Service
public class CondominiumService implements ICondominiumService{

    @Autowired
    private CondominiumRepository repository;

    @Autowired
    private CondominiumMapper mapper;

    @Override
    public List<CondominiumDTO> getAll() {
        return mapper.modelListToDtoListMap(repository.findAll());
    }

    @Override
    public CondominiumDTO save(CondominiumDTO dto) {
        var model = repository.save(mapper.dtoToModelMap(dto));
        log.info(String.format("Condominium '%s' saved successfully.", model.getName()));
        return mapper.modelToDtoMap(model);
    }

    @Override
    public CondominiumDTO findById(Integer id) {
        var model = repository.findById(id).get();

        return mapper.modelToDtoMap(model);
    }

    @Override
    public CondominiumDTO findByName(String name) {
        Assert.notNull(name, "Não foi possível localizar o condomínio. Favor, informar o nome do condomínio.");

       var model = (repository.findByName(name));
       if (model == null) return null;

       return mapper.modelToDtoMap(model);
    }

    @Override
    public CondominiumDTO update(CondominiumDTO dto, Integer id) {
        Assert.notNull(id, "Não foi possível atualizar o condomínio. Favor, informar o id.");
        Condominium model = null;
        var data = findById(id);
        if(data != null) {
            model = Condominium.builder()
                    .id(data.getId())
                    .name(dto.getName())
                    .cnpj(dto.getCnpj())
                    .adress(dto.getAdress())
                    .complement(dto.getComplement())
                    .number(dto.getNumber())
                    .neighborhood(dto.getNeighborhood())
                    .city(dto.getCity())
                    .uf(dto.getUf())
                    .localizationX(dto.getLocalizationX())
                    .localizationY(dto.getLocalizationY())
                    .build();
            repository.save(model);
        }else {
            throw new RuntimeException("Condomínio não encontrado na base de dados.");
        }
        log.info(String.format("Condominium '%s' updated successfully.", model.getName()));
        return mapper.modelToDtoMap(model);
    }

    @Override
    public void delete(Integer id) {
        var dto = findById(id);
        if (dto != null){
            repository.delete(mapper.dtoToModelMap(dto));
        }else {
            throw new RuntimeException("Condomínio não encontrado na base de dados.");
        }
        log.info(String.format("Condominium '%s' deleted successfully.", dto.getName()));
    }
}

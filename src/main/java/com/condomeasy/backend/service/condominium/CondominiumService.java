package com.condomeasy.backend.service.condominium;

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

    @Override
    public List<Condominium> getAll() {
        return repository.findAll();
    }

    @Override
    public Condominium save(Condominium c) {
        var result = repository.save(c);

        log.info(String.format("Condominium '%s' saved successfully.", c.getName()));

        return result;
    }

    @Override
    public Condominium findById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public Condominium update(Condominium c, Integer id) {
        Assert.notNull(id, "Não foi possível atualizar o registro. Favor, informar o id.");

        Condominium newCondominium = null;

        var data = findById(id);

        if(data != null) {
            newCondominium = Condominium.builder()
                    .id(data.getId())
                    .name(c.getName())
                    .cnpj(c.getCnpj())
                    .adress(c.getAdress())
                    .complement(c.getComplement())
                    .number(c.getNumber())
                    .neighborhood(c.getNeighborhood())
                    .city(c.getCity())
                    .uf(c.getUf())
                    .localizationX(c.getLocalizationX())
                    .localizationY(c.getLocalizationY())
                    .build();

            repository.save(newCondominium);

        }else {
            throw new RuntimeException("Condomínio não encontrado na base de dados.");
        }

        log.info(String.format("Condominium '%s' updated successfully.", c.getName()));

        return newCondominium;
    }

    @Override
    public void delete(Integer id) {

        var result = findById(id);

        if (result != null){
            repository.delete(result);
        }else {
            throw new RuntimeException("Condomínio não encontrado na base de dados.");
        }

        log.info(String.format("Condominium '%s' deleted successfully.", result.getName()));
    }
}

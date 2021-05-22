package com.condomeasy.backend.service.impl;

import com.condomeasy.backend.model.Advertisement;
import com.condomeasy.backend.model.User;
import com.condomeasy.backend.repository.AdvertisementRepository;
import com.condomeasy.backend.repository.UserRepository;
import com.condomeasy.backend.service.IAdvertisementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Slf4j
@Service
public class AdvertisementService implements IAdvertisementService {

    @Autowired
    private AdvertisementRepository repository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Advertisement> getAll() {
        return repository.findAll();
    }

    @Override
    public Advertisement save(Advertisement a) {
        return repository.save(a);
    }

    @Override
    public Advertisement update(Advertisement a, Integer id) {
        Assert.notNull(id, "Não foi possível atualizar o registro. Favor, informar o id.");

        Advertisement newAdvertisement = null;

        var data = findById(id);

        if(data != null) {
            newAdvertisement = Advertisement.builder()
                    .id(data.getId())
                    .name(a.getName())
                    .description(a.getDescription())
                    .value(a.getValue())
                    .category(null)
                    .user(userRepository.findById(data.getUser().getId()).get())
                    .build();

            repository.save(newAdvertisement);
        }

        log.info(String.format("Advertisement '%s' updated successfully.", a.getName()));

        return newAdvertisement;
    }

    @Override
    public void delete(Integer id) {
        var result = findById(id);

        if (result != null){
            repository.delete(result);
        }else {
            throw new RuntimeException("Condomínio não encontrado na base de dados.");
        }

        log.info(String.format("Advertisement '%s' deleted successfully.", result.getName()));
    }

    @Override
    public Advertisement findById(Integer id) {
        return repository.findById(id).get();
    }
}

package com.condomeasy.backend.service;

import com.condomeasy.backend.model.Advertisement;

import java.util.List;

public interface IAdvertisementService {

    List<Advertisement> getAll();
    Advertisement save(Advertisement a);
    Advertisement update(Advertisement a, Integer id);
    void delete(Integer c);
    Advertisement findById(Integer id);

}

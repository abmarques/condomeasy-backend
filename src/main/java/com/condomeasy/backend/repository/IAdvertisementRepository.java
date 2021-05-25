package com.condomeasy.backend.repository;

import com.condomeasy.backend.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdvertisementRepository extends JpaRepository<Advertisement, Integer> {
}

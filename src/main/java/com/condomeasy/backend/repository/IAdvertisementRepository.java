package com.condomeasy.backend.repository;

import com.condomeasy.backend.model.Advertisement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdvertisementRepository extends JpaRepository<Advertisement, Integer> {
	List<Advertisement> findByCategoryId(Integer id);
}

package com.condomeasy.backend.repository;

import com.condomeasy.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}

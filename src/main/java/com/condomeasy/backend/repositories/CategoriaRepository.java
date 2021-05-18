package com.condomeasy.backend.repositories;

import com.condomeasy.backend.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}

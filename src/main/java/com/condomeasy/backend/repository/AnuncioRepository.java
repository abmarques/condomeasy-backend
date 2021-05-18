package com.condomeasy.backend.repository;

import com.condomeasy.backend.model.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {
}

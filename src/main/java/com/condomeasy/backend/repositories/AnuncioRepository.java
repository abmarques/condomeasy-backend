package com.condomeasy.backend.repositories;

import com.condomeasy.backend.models.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {
}

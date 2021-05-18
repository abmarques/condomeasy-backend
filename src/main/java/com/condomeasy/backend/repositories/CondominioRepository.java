package com.condomeasy.backend.repositories;

import com.condomeasy.backend.models.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondominioRepository extends JpaRepository<Condominio, Integer> {
}

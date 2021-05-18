package com.condomeasy.backend.repository;

import com.condomeasy.backend.model.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondominioRepository extends JpaRepository<Condominio, Integer> {
}

package com.condomeasy.backend.repository;

import com.condomeasy.backend.model.Condominium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondominiumRepository extends JpaRepository<Condominium, Integer> {
}

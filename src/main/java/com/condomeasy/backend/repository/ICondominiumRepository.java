package com.condomeasy.backend.repository;

import com.condomeasy.backend.model.Condominium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICondominiumRepository extends JpaRepository<Condominium, Integer> {
    Optional<Condominium> findByName(String name);
}

package com.condomeasy.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condomeasy.backend.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByCpf(String cpf);
    
}

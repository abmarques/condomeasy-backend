package com.condomeasy.backend.repository;

import com.condomeasy.backend.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfileRepository extends JpaRepository<Profile, Integer> {
}

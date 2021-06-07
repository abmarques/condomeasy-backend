package com.condomeasy.backend.repository;

import com.condomeasy.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByCpf(String cpf);

    @Modifying
    @Transactional
    @Query("update User u set u.password = :password where u.id = :id")
    void updatePassword(@Param("password") String password, @Param("id") Integer id);

}

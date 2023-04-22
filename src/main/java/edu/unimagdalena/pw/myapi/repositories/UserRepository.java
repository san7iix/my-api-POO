package edu.unimagdalena.pw.myapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unimagdalena.pw.myapi.entidades.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    
}

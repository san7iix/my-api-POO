package edu.unimagdalena.pw.myapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.unimagdalena.pw.myapi.entidades.ERole;
import edu.unimagdalena.pw.myapi.entidades.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(ERole name);
}

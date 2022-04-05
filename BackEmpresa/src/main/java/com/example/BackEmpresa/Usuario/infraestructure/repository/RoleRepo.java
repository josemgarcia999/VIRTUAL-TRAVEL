package com.example.BackEmpresa.Usuario.infraestructure.repository;

import com.example.BackEmpresa.Usuario.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);
}

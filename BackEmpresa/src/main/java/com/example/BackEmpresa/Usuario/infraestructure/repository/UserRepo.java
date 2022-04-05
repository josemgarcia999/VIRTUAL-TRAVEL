package com.example.BackEmpresa.Usuario.infraestructure.repository;

import com.example.BackEmpresa.Usuario.domain.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UsuarioEntity,Long> {
    UsuarioEntity findByUsername(String username);
}

package com.example.BackEmpresa.Correo.infraestructure.repository;

import com.example.BackEmpresa.Correo.domain.CorreoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorreoRepo extends JpaRepository<CorreoEntity,Integer> {
    public List<CorreoEntity> findByEmail(String email);
}

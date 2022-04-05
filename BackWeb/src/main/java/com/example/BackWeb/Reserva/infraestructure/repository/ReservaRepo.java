package com.example.BackWeb.Reserva.infraestructure.repository;

import com.example.BackWeb.Reserva.domain.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<ReservaEntity,Integer> {
    List<ReservaEntity> findByCiudadDestino(String ciudadDestino);
}

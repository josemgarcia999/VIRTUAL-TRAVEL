package com.example.BackEmpresa.Reserva.infraestructure.repository;

import com.example.BackEmpresa.Reserva.domain.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<ReservaEntity,Integer> {
    ReservaEntity findByCiudadDestinoAndEmailAndFechaReservaAndHoraReserva(String ciudadDestino, String email, Date fechaReserva, Float horaReserva);
    List<ReservaEntity> findByCiudadDestino(String ciudadDestino);
}

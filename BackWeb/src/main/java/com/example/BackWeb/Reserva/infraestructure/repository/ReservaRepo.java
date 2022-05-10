package com.example.BackWeb.Reserva.infraestructure.repository;

import com.example.BackWeb.Reserva.domain.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<ReservaEntity,Integer> {
    List<ReservaEntity> findByCiudadDestino(String ciudadDestino);
    ReservaEntity findByCiudadDestinoAndEmailAndFechaReservaAndHoraReserva(String ciudadDestino, String email, Date fechaReserva, Float horaReserva);
    void deleteByCiudadDestinoAndEmailAndFechaReservaAndHoraReserva(String ciudadDestino, String email, Date fechaReserva, Float horaReserva);

}

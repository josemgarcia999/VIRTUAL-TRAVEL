package com.example.BackWeb.Bus.infraestructure.repository;


import com.example.BackWeb.Bus.domain.BusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BusRepo extends JpaRepository<BusEntity,Integer> {
    public BusEntity findByCiudadDestinoAndHoraAndFecha(String ciudadDestino,Float hora, Date fecha);
    public BusEntity findByCiudadDestino(String ciudadDestino);
}

package com.example.BackWeb.Bus.domain;


import com.example.BackWeb.Reserva.domain.ReservaEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String ciudadDestino;
    Float hora;
    Date fecha;
    Integer capacidad;
    @JsonManagedReference
    @OneToMany(mappedBy = "busAsignado", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ReservaEntity> reservasAsignadas;

    public BusEntity(String ciudadDestino, Float hora, Date fecha){
        reservasAsignadas = new ArrayList<>();
        setCiudadDestino(ciudadDestino);
        setHora(hora);
        setFecha(fecha);
        setCapacidad(40);
    }

}


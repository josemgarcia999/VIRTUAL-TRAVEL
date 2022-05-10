package com.example.BackEmpresa.Bus.domain;


import com.example.BackEmpresa.Reserva.domain.ReservaEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


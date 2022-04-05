package com.example.BackEmpresa.Bus.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

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

    public BusEntity(String ciudadDestino, Float hora, Date fecha){
        setCiudadDestino(ciudadDestino);
        setHora(hora);
        setFecha(fecha);
        setCapacidad(39);
    }

}


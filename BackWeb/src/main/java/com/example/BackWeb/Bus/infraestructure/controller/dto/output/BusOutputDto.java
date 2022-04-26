package com.example.BackWeb.Bus.infraestructure.controller.dto.output;

import com.example.BackWeb.Bus.domain.BusEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusOutputDto {
    Integer id;
    String dia;
    Float hora;
    Date fecha;
    Integer capacidad;
    List<String> reservasRealizadas;

    public BusOutputDto(BusEntity bus) {
        setId(bus.getId());
        setDia(bus.getCiudadDestino());
        setHora(bus.getHora());
        setFecha(bus.getFecha());
        setCapacidad(bus.getCapacidad());
        reservasRealizadas = new ArrayList<>();
        for (int i = 0; i < bus.getReservasAsignadas().size(); i++) {
            reservasRealizadas.add(bus.getReservasAsignadas().get(i).toString());
        }


    }

}


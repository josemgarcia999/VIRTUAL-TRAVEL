package com.example.BackEmpresa.Bus.infraestructure.controller.dto.output;

import com.example.BackEmpresa.Bus.domain.BusEntity;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusOutputDto {
    Integer id;
    String dia;
    Float hora;
    Date fecha;
    Integer capacidad;

public BusOutputDto(BusEntity bus){
    setId(bus.getId());
    setDia(bus.getCiudadDestino());
    setHora(bus.getHora());
    setFecha(bus.getFecha());
    setCapacidad(bus.getCapacidad());

}

}

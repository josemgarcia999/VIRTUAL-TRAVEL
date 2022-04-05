package com.example.BackWeb.Reserva.infraestructure.controller.dto.output;

import com.example.BackWeb.Reserva.domain.ReservaEntity;
import lombok.Data;

import java.util.Date;

@Data
public class ReservaOutputDTO {

    String ciudadDestino;
    String nombre;
    String apellido;
    String telefono;
    String email;
    Date fechaReserva;
    Float horaReserva;


    public ReservaOutputDTO(ReservaEntity reserva) {
        setCiudadDestino(reserva.getCiudadDestino());
        setNombre(reserva.getNombre());
        setApellido(reserva.getApellido());
        setTelefono(reserva.getTelefono());
        setEmail(reserva.getEmail());
        setFechaReserva(reserva.getFechaReserva());
        setHoraReserva(reserva.getHoraReserva());
    }


}

package com.example.BackWeb.Reserva.infraestructure.controller.dto.output;

import com.example.BackWeb.Reserva.domain.ReservaEntity;
import lombok.Data;

import java.util.Date;

@Data
public class ReservaOutputDTO {

    Integer id;
    String ciudadDestino;
    String nombre;
    String apellido;
    String telefono;
    String email;
    Date fechaReserva;
    Float horaReserva;
    String estado;


    public ReservaOutputDTO(ReservaEntity reserva) {
        setId(reserva.getId());
        setCiudadDestino(reserva.getCiudadDestino());
        setNombre(reserva.getNombre());
        setApellido(reserva.getApellido());
        setTelefono(reserva.getTelefono());
        setEmail(reserva.getEmail());
        setFechaReserva(reserva.getFechaReserva());
        setHoraReserva(reserva.getHoraReserva());
        setEstado(reserva.getEstado());
    }


}

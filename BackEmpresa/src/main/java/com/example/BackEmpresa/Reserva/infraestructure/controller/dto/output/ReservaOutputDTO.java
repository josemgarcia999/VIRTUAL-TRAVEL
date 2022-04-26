package com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output;

import com.example.BackEmpresa.Bus.domain.BusEntity;
import com.example.BackEmpresa.Reserva.domain.ReservaEntity;
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
    Integer idBus;


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
        if(reserva.getBusAsignado() == null) {
            setIdBus(null);
        } else
            setIdBus(reserva.getBusAsignado().getId());
    }


}

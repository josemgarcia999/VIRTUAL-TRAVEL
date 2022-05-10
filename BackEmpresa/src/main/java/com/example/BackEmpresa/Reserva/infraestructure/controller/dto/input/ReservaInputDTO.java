package com.example.BackEmpresa.Reserva.infraestructure.controller.dto.input;

import com.example.BackEmpresa.Reserva.domain.ReservaEntity;
import com.example.BackEmpresa.shared.Validator.checkCiudadDestino;
import com.example.BackEmpresa.shared.Validator.horaReserva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReservaInputDTO {

    @NotNull
    @checkCiudadDestino
    String ciudadDestino;
    @NotNull
    String nombre;
    @NotNull
    String apellido;
    @NotNull
    String telefono;
    @NotNull
    String email;
    @NotNull
    Date fechaReserva;
    @horaReserva
    Float horaReserva;

    @Override
    public String toString() {
        return "ReservaInputDTO{" +
                "ciudadDestino='" + ciudadDestino + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", fechaReserva=" + fechaReserva +
                ", horaReserva=" + horaReserva +
                '}';
    }

    public ReservaInputDTO(ReservaEntity reserva){
        setCiudadDestino(reserva.getCiudadDestino());
        setNombre(reserva.getNombre());
        setApellido(reserva.getApellido());
        setTelefono(reserva.getTelefono());
        setEmail(reserva.getEmail());
        setHoraReserva(reserva.getHoraReserva());
        setFechaReserva(reserva.getFechaReserva());
    }

    public ReservaInputDTO(String ciudadDestino,String email, Date fechaReserva, Float horaReserva){
        setCiudadDestino(ciudadDestino);
        setEmail(email);
        setFechaReserva(fechaReserva);
        setHoraReserva(horaReserva);
        setNombre("Borrado");
        setApellido("Borrado");
        setTelefono("Borrado");

    }

}

package com.example.BackEmpresa.Reserva.infraestructure.controller.dto.input;

import com.example.BackEmpresa.Reserva.domain.ReservaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaInputDTO {

    @NotNull
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
    @NotNull
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

}

package com.example.BackEmpresa.Correo.infraestructure.controller.dto.input;

import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CorreoInputDto {

    @NotNull (message = "Ciudad destino no puede ser nulo")
    String ciudadDestino;
    @NotNull (message = "Email no puede ser nulo")
    String email;
    @NotNull (message = "Fecha Reserva no puede ser nulo")
    Date fechaReserva;
    @NotNull (message = "Hora reserva no puede ser nulo")
    Float horaReserva;

    public CorreoInputDto(ReservaOutputDTO reserva){
        setCiudadDestino(reserva.getCiudadDestino());
        setEmail(reserva.getEmail());
        setFechaReserva(reserva.getFechaReserva());
        setHoraReserva(reserva.getHoraReserva());
    }

}

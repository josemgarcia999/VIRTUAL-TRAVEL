package com.example.BackEmpresa.Reserva.infraestructure.controller.dto.input;

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

}

package com.example.BackWeb.Reserva.infraestructure.controller.dto.input;

import com.example.BackWeb.shared.Validator.checkCiudadDestino;
import com.example.BackWeb.shared.Validator.horaReserva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
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
    @Email
    String email;
    @NotNull
    Date fechaReserva;
    @NotNull
    @horaReserva
    Float horaReserva;

}

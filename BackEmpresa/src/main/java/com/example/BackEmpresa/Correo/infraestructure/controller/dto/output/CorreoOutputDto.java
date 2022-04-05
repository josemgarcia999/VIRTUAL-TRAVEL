package com.example.BackEmpresa.Correo.infraestructure.controller.dto.output;

import com.example.BackEmpresa.Correo.domain.CorreoEntity;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class CorreoOutputDto {
    Integer id;
    String ciudadDestino;
    String email;
    Date fechaReserva;
    Float horaReserva;

    public CorreoOutputDto(CorreoEntity correo){
        setId(correo.getId());
        setCiudadDestino(correo.getCiudadDestino());
        setEmail(correo.getEmail());
        setFechaReserva(correo.getFechaReserva());
        setHoraReserva(correo.getHoraReserva());
    }





}

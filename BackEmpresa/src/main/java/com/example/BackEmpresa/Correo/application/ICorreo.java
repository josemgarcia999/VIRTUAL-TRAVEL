package com.example.BackEmpresa.Correo.application;

import com.example.BackEmpresa.Correo.domain.CorreoEntity;
import com.example.BackEmpresa.Correo.infraestructure.controller.dto.input.CorreoInputDto;
import com.example.BackEmpresa.Correo.infraestructure.controller.dto.output.CorreoListaOutputDto;
import com.example.BackEmpresa.Correo.infraestructure.controller.dto.output.CorreoOutputDto;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;

import java.util.Date;
import java.util.List;

public interface ICorreo {
    CorreoListaOutputDto getAllCorreos();
    public void sendEmail(ReservaOutputDTO reservaOutputDTO);
    public CorreoListaOutputDto findCorreoByEmail(String email);
    public CorreoListaOutputDto obtenerCorreos(String ciudadDestino, Date fechaMax, Date fechaMin, Float horaMax, Float horaMin);
    public CorreoOutputDto reenviarEmail(CorreoInputDto correoInputDto);


    }

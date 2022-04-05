package com.example.BackEmpresa.Correo.application;

import com.example.BackEmpresa.Correo.infraestructure.controller.dto.input.CorreoInputDto;
import com.example.BackEmpresa.Correo.infraestructure.controller.dto.output.CorreoListaOutputDto;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;

public interface ICorreo {
    CorreoListaOutputDto getAllCorreos();
    public void sendEmail(ReservaOutputDTO reservaOutputDTO);
    public CorreoListaOutputDto findCorreoByEmail(String email);

}

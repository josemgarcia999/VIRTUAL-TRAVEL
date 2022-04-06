package com.example.BackEmpresa.Correo.infraestructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuscarCorreoDto {


    String ciudadDestino;
    Date fechaInferior;
    Date fechaSuperior;
    Float horaInferior;
    Float horaSuperior;


}

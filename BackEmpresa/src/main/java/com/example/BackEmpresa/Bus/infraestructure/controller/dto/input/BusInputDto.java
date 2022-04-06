package com.example.BackEmpresa.Bus.infraestructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusInputDto {

    String ciudadDestino;
    Float hora;
    Date fecha;

}

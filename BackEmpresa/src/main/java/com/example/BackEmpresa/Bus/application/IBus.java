package com.example.BackEmpresa.Bus.application;

import com.example.BackEmpresa.Bus.infraestructure.controller.dto.output.BusListaOutputDto;
import com.example.BackEmpresa.Bus.infraestructure.controller.dto.output.BusOutputDto;

import java.util.Date;
import java.util.List;

public interface IBus {

    public BusListaOutputDto findAll();
    public BusOutputDto findById(Integer id) throws Exception;
    public BusOutputDto findByCiudadDestino(String ciudadDestino);
    public void deleteById(Integer id);
    public void deleteAll();
    public String obtenerCapacidadViaje(String ciudadDestino, Date fechaViaje, Float horaViaje);


}

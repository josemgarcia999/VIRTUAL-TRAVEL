package com.example.BackWeb.Bus.application;

import com.example.BackWeb.Bus.infraestructure.controller.dto.output.BusListaOutputDto;
import com.example.BackWeb.Bus.infraestructure.controller.dto.output.BusOutputDto;

import java.util.Date;

public interface IBus {

    public BusListaOutputDto findAll();
    public BusOutputDto findById(Integer id) throws Exception;
    public BusOutputDto findByCiudadDestino(String ciudadDestino);
    public void deleteById(Integer id);
    public void deleteAll();
    public int obtenerCapacidadViaje(String ciudadDestino, Date fechaViaje, Float horaViaje);

}

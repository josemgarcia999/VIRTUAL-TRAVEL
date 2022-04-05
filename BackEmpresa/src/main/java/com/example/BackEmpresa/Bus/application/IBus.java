package com.example.BackEmpresa.Bus.application;

import com.example.BackEmpresa.Bus.infraestructure.controller.dto.output.BusOutputDto;

import java.util.List;

public interface IBus {

    List<BusOutputDto> findAll();
    public BusOutputDto findById(Integer id) throws Exception;
    public BusOutputDto findByCiudadDestino(String ciudadDestino);
    public void deleteById(Integer id);
    public void deleteAll();

}

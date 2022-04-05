package com.example.BackEmpresa.Bus.infraestructure.controller;


import com.example.BackEmpresa.Bus.application.IBus;
import com.example.BackEmpresa.Bus.infraestructure.controller.dto.output.BusOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/reservasDisponibles")
public class ReadBusController {

    @Autowired
    IBus reservasRealizadasService;


    @GetMapping
    public List<BusOutputDto> getAllReservas(){
        return reservasRealizadasService.findAll();
    }

}

package com.example.BackEmpresa.Reserva.infraestructure.controller;


import com.example.BackEmpresa.Reserva.application.IReserva;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaListaOutputDTO;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ReadReservaController {

    @Autowired
    IReserva reservaService;

    @GetMapping
    public ReservaListaOutputDTO findAll(){
        return reservaService.findAll();
    }
    @GetMapping("{id}")
    public ReservaOutputDTO findById(@PathVariable Integer id) throws Exception {
        return reservaService.findById(id);
    }

    @GetMapping("reservas/{ciudadDestino}")
    public ReservaListaOutputDTO findByCiudadDestino(@PathVariable String ciudadDestino){
        return reservaService.findByCiudadDestino(ciudadDestino);
    }


}

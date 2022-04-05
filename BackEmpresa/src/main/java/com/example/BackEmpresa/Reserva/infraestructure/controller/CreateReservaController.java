package com.example.BackEmpresa.Reserva.infraestructure.controller;


import com.example.BackEmpresa.Reserva.application.IReserva;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/reservas")
public class CreateReservaController {

    @Autowired
    IReserva reservaService;

    @PostMapping()
    public ReservaOutputDTO addReserva(@RequestBody ReservaInputDTO reservaInputDTO){
        return reservaService.realizarReserva(reservaInputDTO);
    }







}

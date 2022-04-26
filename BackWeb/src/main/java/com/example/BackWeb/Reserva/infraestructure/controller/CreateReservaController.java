package com.example.BackWeb.Reserva.infraestructure.controller;


import com.example.BackWeb.Reserva.application.IReserva;
import com.example.BackWeb.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import com.example.BackWeb.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/web/reservas")
public class CreateReservaController {

    @Autowired
    IReserva reservaService;


    @PostMapping()
    public ResponseEntity<ReservaOutputDTO> addReserva(@Valid @RequestBody ReservaInputDTO reservaInputDTO){
        return ResponseEntity.ok().body(reservaService.realizarReserva(reservaInputDTO));
    }







}

package com.example.BackEmpresa.Reserva.infraestructure.controller;


import com.example.BackEmpresa.Reserva.application.IReserva;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/empresa/reservas")
public class CreateReservaController {

    @Autowired
    IReserva reservaService;

    @PostMapping()
    public ResponseEntity<ReservaOutputDTO> addReserva(@RequestBody @Valid ReservaInputDTO reservaInputDTO){
        return ResponseEntity.ok().body(reservaService.realizarReserva(reservaInputDTO));
    }







}

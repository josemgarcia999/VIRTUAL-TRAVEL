package com.example.BackWeb.Reserva.infraestructure.controller;


import com.example.BackWeb.Reserva.application.IReserva;
import com.example.BackWeb.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import com.example.BackWeb.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/reservas")
public class CreateReservaController {

    @Autowired
    IReserva reservaService;

    @PostMapping()
    public ResponseEntity<ReservaOutputDTO> addReserva(@RequestBody ReservaInputDTO reservaInputDTO){
        return ResponseEntity.ok().body(reservaService.realizarReserva(reservaInputDTO));
    }







}

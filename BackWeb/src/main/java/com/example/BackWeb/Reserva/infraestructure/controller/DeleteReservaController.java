package com.example.BackWeb.Reserva.infraestructure.controller;

import com.example.BackWeb.Reserva.application.IReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("api/web/reservas")
@RestController
public class DeleteReservaController {

    @Autowired
    IReserva reservaService;


    @DeleteMapping("{id}")
    public void deleteReservaById(@PathVariable Integer id){
        reservaService.deleteById(id);
    }

}




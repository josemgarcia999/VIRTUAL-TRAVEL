package com.example.BackEmpresa.Reserva.infraestructure.controller;


import com.example.BackEmpresa.Reserva.application.IReserva;
import com.example.BackEmpresa.Reserva.infraestructure.repository.ReservaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/empresa/reservas")
@RestController
public class DeleteReservaController {

    @Autowired
    IReserva reservaService;


    @DeleteMapping("{id}")
    public void deleteReservaById(@PathVariable Integer id){
        reservaService.deleteById(id);
    }

}

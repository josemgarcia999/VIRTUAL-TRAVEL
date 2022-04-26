package com.example.BackEmpresa.Bus.infraestructure.controller;


import com.example.BackEmpresa.Bus.application.IBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empresa/reservasDisponibles")
public class DeleteBusController {


    @Autowired
    IBus reservasDisponiblesRepo;


    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id){
        reservasDisponiblesRepo.deleteById(id);
    }

}

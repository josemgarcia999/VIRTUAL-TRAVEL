package com.example.BackEmpresa.Reserva.infraestructure.controller;


import com.example.BackEmpresa.Reserva.application.IReserva;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaListaOutputDTO;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ReservaListaOutputDTO> findAll(){
        return ResponseEntity.ok().body(reservaService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<ReservaOutputDTO> findById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok().body(reservaService.findById(id));
    }

    @GetMapping("reservas/{ciudadDestino}")
    public ResponseEntity<ReservaListaOutputDTO> findByCiudadDestino(@PathVariable String ciudadDestino){
        return ResponseEntity.ok().body(reservaService.findByCiudadDestino(ciudadDestino));
    }


}

package com.example.BackWeb.Bus.infraestructure.controller;


import com.example.BackWeb.Bus.application.IBus;
import com.example.BackWeb.Bus.infraestructure.controller.dto.input.BusInputDto;
import com.example.BackWeb.Bus.infraestructure.controller.dto.output.BusListaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web/reservasDisponibles")
public class ReadBusController {

    @Autowired
    IBus reservasRealizadasService;


    @GetMapping
    public ResponseEntity<BusListaOutputDto> getAllReservas() {
        return ResponseEntity.ok().body(reservasRealizadasService.findAll());
    }


    @GetMapping("capacidad")
    ResponseEntity<String> obtenerCapacidadViaje(@RequestBody BusInputDto viaje){
        return ResponseEntity.ok().body(reservasRealizadasService.obtenerCapacidadViaje(viaje.getCiudadDestino(),viaje.getFecha(),viaje.getHora()));
    }

}

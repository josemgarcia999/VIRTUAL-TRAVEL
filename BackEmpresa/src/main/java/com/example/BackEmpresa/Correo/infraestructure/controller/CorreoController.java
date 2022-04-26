package com.example.BackEmpresa.Correo.infraestructure.controller;

import com.example.BackEmpresa.Correo.application.ICorreo;
import com.example.BackEmpresa.Correo.domain.CorreoEntity;
import com.example.BackEmpresa.Correo.infraestructure.controller.dto.input.BuscarCorreoDto;
import com.example.BackEmpresa.Correo.infraestructure.controller.dto.input.CorreoInputDto;
import com.example.BackEmpresa.Correo.infraestructure.controller.dto.output.CorreoListaOutputDto;
import com.example.BackEmpresa.Correo.infraestructure.controller.dto.output.CorreoOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/empresa/correos")
public class CorreoController {

    @Autowired
    ICorreo correoService;

    @GetMapping("/filtrar")
    public ResponseEntity<CorreoListaOutputDto> obtenerCorreos(@RequestBody BuscarCorreoDto datos){
            return ResponseEntity.ok().body(correoService.obtenerCorreos(datos.getCiudadDestino(), datos.getFechaSuperior(),datos.getFechaInferior(),datos.getHoraSuperior(),datos.getHoraInferior()));
    }
    @PutMapping
    public ResponseEntity<CorreoOutputDto> reenviarCorreo(@RequestBody CorreoInputDto correo){
        return ResponseEntity.ok().body(correoService.reenviarEmail(correo));
    }


    @GetMapping
    public ResponseEntity<CorreoListaOutputDto> getAllCorreos(){
        return ResponseEntity.ok().body(correoService.getAllCorreos());
    }








}

package com.example.BackEmpresa.Correo.infraestructure.controller;

import com.example.BackEmpresa.Correo.application.ICorreo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/correo")
public class CorreoController {

    @Autowired
    ICorreo correoService;




//
//    @PostMapping
//    public void enviarCorreoPrueba(){
//        correoService.sendEmail2();
//    }




}

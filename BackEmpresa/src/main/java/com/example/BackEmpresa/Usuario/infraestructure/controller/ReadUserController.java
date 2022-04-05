package com.example.BackEmpresa.Usuario.infraestructure.controller;

import com.example.BackEmpresa.Usuario.application.IUsuario;
import com.example.BackEmpresa.Usuario.application.UsuarioService;
import com.example.BackEmpresa.Usuario.domain.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NamedEntityGraph;
import java.util.List;

@RestController
@RequestMapping("api")
public class ReadUserController {
    @Autowired
    IUsuario usuarioService;

    @GetMapping("/users")
    public ResponseEntity<List<UsuarioEntity>>getUsers(){
        return ResponseEntity.ok().body(usuarioService.getUsers());
    }























}

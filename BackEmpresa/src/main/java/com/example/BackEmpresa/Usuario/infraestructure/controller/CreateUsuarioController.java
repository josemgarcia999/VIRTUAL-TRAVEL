package com.example.BackEmpresa.Usuario.infraestructure.controller;


import com.example.BackEmpresa.Usuario.application.IUsuario;
import com.example.BackEmpresa.Usuario.domain.Role;
import com.example.BackEmpresa.Usuario.domain.UsuarioEntity;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api")
public class CreateUsuarioController {

    @Autowired
    IUsuario usuarioService;

    @PostMapping("user/save")
    public ResponseEntity<UsuarioEntity>saveUser(@RequestBody UsuarioEntity user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(usuarioService.saveUser(user));
    }

    @PostMapping("role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(usuarioService.saveRole(role));
    }

    @PostMapping("role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form){
        usuarioService.addRoleToUser(form.getUsername(),form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @Data
    class RoleToUserForm{
        String username;
        String roleName;


    }

}

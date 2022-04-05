package com.example.BackEmpresa.Usuario.application;

import com.example.BackEmpresa.Usuario.domain.Role;
import com.example.BackEmpresa.Usuario.domain.UsuarioEntity;

import java.util.List;

public interface IUsuario {
    UsuarioEntity saveUser(UsuarioEntity user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    UsuarioEntity getUser(String username);
    List<UsuarioEntity> getUsers();


}

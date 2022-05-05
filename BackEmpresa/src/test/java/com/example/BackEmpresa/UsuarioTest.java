package com.example.BackEmpresa;

import com.example.BackEmpresa.BackEmpresaApplication;
import com.example.BackEmpresa.Usuario.application.UsuarioService;
import com.example.BackEmpresa.Usuario.domain.Role;
import com.example.BackEmpresa.Usuario.domain.UsuarioEntity;
import com.example.BackEmpresa.Usuario.infraestructure.repository.RoleRepo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = BackEmpresaApplication.class)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioTest {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RoleRepo roleRepo;

    Integer idPersona1=1;
    Integer idPersona2=2;
    String usuario1="josemgarcia999";
    String usuario2="juanmy999";

    @BeforeAll
    void checkBeanMain() {
        assertEquals(usuarioService.getUsers().size(),2);

    }

    @Test
    void saveUser(){
        usuarioService.saveUser(new UsuarioEntity(3,"chuchi123","1234",new ArrayList<>()));
        assertEquals(usuarioService.getUsers().size(),3);
    }


    @Test
    void findByUsernameTest() {
        assertEquals(usuario1, usuarioService.getUser(usuario1).getUsername());
        assertEquals(usuario2, usuarioService.getUser(usuario2).getUsername());
    }
    @Test
    void saveRole(){
        usuarioService.saveRole(new Role(Long.valueOf(5),"ROLE_PRUEBA"));
        assertEquals(roleRepo.findAll().size(),5);
    }





}

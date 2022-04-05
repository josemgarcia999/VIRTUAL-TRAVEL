package com.example.BackEmpresa.Usuario.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String username;
    String password;
    @ManyToMany(fetch = FetchType.EAGER)
    Collection<Role> roles = new ArrayList<>();



}

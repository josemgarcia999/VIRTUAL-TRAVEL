package com.example.BackEmpresa.Usuario.application;

import com.example.BackEmpresa.Usuario.domain.Role;
import com.example.BackEmpresa.Usuario.domain.UsuarioEntity;
import com.example.BackEmpresa.Usuario.infraestructure.repository.RoleRepo;
import com.example.BackEmpresa.Usuario.infraestructure.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
//Min 23,33
public class UsuarioService implements IUsuario , UserDetailsService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    PasswordEncoder passwordEncoder;






    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity user = userRepo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Usuario no encontrado en la Base de Datos");
        }else{
            log.info("Usuario encontrado en BBDD: {}",username);
            log.info("Rol de usuario: {}",user.getRoles());
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority(role.getName()));
        });


        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);

    }


    @Override
    public UsuarioEntity saveUser(UsuarioEntity user) {
        log.info("Guardando usuario en base de datos.",user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Guardando rol en base de datos",role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
    log.info("Asignando rol a usuario",username);
    UsuarioEntity user = userRepo.findByUsername(username);
    Role role = roleRepo.findByName(roleName);
    user.getRoles().add(role);
    userRepo.save(user);
    }

    @Override
    public UsuarioEntity getUser(String username) {
        log.info("Obteniendo usuario",username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<UsuarioEntity> getUsers() {
        log.info("Obteniendo todos los usuarios");
        return userRepo.findAll();
    }

}

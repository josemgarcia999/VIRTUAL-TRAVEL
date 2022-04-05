package com.example.BackEmpresa;

import com.example.BackEmpresa.Usuario.application.UsuarioService;
import com.example.BackEmpresa.Usuario.domain.Role;
import com.example.BackEmpresa.Usuario.domain.UsuarioEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class BackEmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEmpresaApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UsuarioService usuarioService){

		return args -> {

			usuarioService.saveRole(new Role(Long.valueOf(1),"ROLE_USER"));
			usuarioService.saveRole(new Role(Long.valueOf(2),"ROLE_MANAGER"));
			usuarioService.saveRole(new Role(Long.valueOf(3),"ROLE_ADMIN"));
			usuarioService.saveRole(new Role(Long.valueOf(4),"ROLE_SUPER_ADMIN"));

			usuarioService.saveUser(new UsuarioEntity(1,"josemgarcia999","1234",new ArrayList<>()));
			usuarioService.saveUser(new UsuarioEntity(2,"juanmy999","1234",new ArrayList<>()));

			usuarioService.addRoleToUser("josemgarcia999","ROLE_ADMIN");
			usuarioService.addRoleToUser("juanmy999","ROLE_USER");


		};

	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS");
			}
		};
	}




}

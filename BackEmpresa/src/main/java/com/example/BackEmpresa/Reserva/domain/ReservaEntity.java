package com.example.BackEmpresa.Reserva.domain;

import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "Reserva")
@NoArgsConstructor
public class ReservaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "CuidadDestino")
    String ciudadDestino;
    @Column(name = "Nombre")
    String nombre;
    @Column(name = "Apellido")
    String apellido;
    @Column(name = "Telefono")
    String telefono;
    @Column(name = "Email")
    String email;
    @Column(name = "FechaReserva")
    Date fechaReserva;
    @Column(name = "HoraReserva")
    Float horaReserva;
    //añadir anotaciones de restricciones
    String estado;


    public ReservaEntity(ReservaInputDTO reservaInputDTO){
        if(reservaInputDTO == null)
        return;
        setCiudadDestino(reservaInputDTO.getCiudadDestino());
        setNombre(reservaInputDTO.getNombre());
        setApellido(reservaInputDTO.getApellido());
        setTelefono(reservaInputDTO.getTelefono());
        setEmail(reservaInputDTO.getEmail());
        setFechaReserva(reservaInputDTO.getFechaReserva());
        setHoraReserva(reservaInputDTO.getHoraReserva());
    }


}

package com.example.BackWeb.Reserva.domain;

import com.example.BackWeb.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;
    @Column(name = "Cuidad de Destino")
    String ciudadDestino;
    @Column(name = "Nombre")
    String nombre;
    @Column(name = "Apellido")
    String apellido;
    @Column(name = "Telefono")
    String telefono;
    @Column(name = "Email")
    String email;
    @Column(name = "Fecha de Reserva")
    Date fechaReserva;
    @Column(name = "Hora de la reserva")
    Float horaReserva;
    //añadir anotaciones de restricciones


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

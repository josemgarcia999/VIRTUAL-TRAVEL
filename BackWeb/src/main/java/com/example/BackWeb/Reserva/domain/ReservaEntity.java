package com.example.BackWeb.Reserva.domain;

import com.example.BackWeb.Bus.domain.BusEntity;
import com.example.BackWeb.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_asignado_id")
    BusEntity busAsignado;

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


    @Override
    public String toString() {
        String datosReserva = "Datos del cliente:" +
                " Plaza Asignada: " + busAsignado.getReservasAsignadas().size()  +
                ", Nombre: " + nombre +
                ", apellido: " + apellido+
                ", telefono: " + telefono +
                ", email: " + email;
        return datosReserva;
    }
}


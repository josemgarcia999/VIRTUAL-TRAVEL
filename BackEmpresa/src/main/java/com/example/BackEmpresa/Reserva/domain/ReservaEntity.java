package com.example.BackEmpresa.Reserva.domain;

import com.example.BackEmpresa.Bus.domain.BusEntity;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import com.example.BackEmpresa.shared.Validator.horaReserva;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;


@Entity
@Data
@Table(name = "Reserva")
@NoArgsConstructor
@Transactional
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
    @horaReserva
    Float horaReserva;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_asignado_id")
    BusEntity busAsignado;

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



    @Override
    public String toString() {
        String datosReserva = "Datos del cliente:" +
                " Plaza Asignada: " + busAsignado.getReservasAsignadas().size() + "↵" +
                ", Nombre: " + nombre +
                ", apellido: " + apellido+
                ", telefono: " + telefono +
                ", email: " + email;
        return datosReserva;
    }
}

package com.example.BackEmpresa.Correo.domain;

import com.example.BackEmpresa.Correo.infraestructure.controller.dto.input.CorreoInputDto;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CorreoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "CiudadDestino")
    String ciudadDestino;
    @NotNull (message = "CorreoElectronico")
    String email;
    @NotNull (message = "FechaReserva")
    Date fechaReserva;
    @NotNull (message = "HoraReserva")
    Float horaReserva;
    @NotNull(message = "idAutobus")
    Integer idAutobus;


    public CorreoEntity(CorreoInputDto correo){
        setCiudadDestino(correo.getCiudadDestino());
        setEmail(correo.getEmail());
        setFechaReserva(correo.getFechaReserva());
        setHoraReserva(correo.getHoraReserva());
        setIdAutobus(correo.getIdAutobus());
    }


}

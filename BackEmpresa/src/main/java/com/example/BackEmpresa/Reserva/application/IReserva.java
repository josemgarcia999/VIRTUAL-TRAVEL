package com.example.BackEmpresa.Reserva.application;

import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaListaOutputDTO;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;

public interface IReserva {
    public ReservaOutputDTO realizarReserva(ReservaInputDTO reservaInputDTO);
    public ReservaOutputDTO findById(Integer id) throws Exception;
    public ReservaListaOutputDTO findAll();
    public ReservaListaOutputDTO findByCiudadDestino(String ciudadDestino);
    public void deleteById(Integer id);
    public void deleteAll();

}

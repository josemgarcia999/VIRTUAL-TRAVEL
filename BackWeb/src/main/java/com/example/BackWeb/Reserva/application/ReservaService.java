package com.example.BackWeb.Reserva.application;

import com.example.BackWeb.Reserva.domain.ReservaEntity;
import com.example.BackWeb.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import com.example.BackWeb.Reserva.infraestructure.controller.dto.output.ReservaListaOutputDTO;
import com.example.BackWeb.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import com.example.BackWeb.Reserva.infraestructure.repository.ReservaRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class ReservaService implements IReserva{

    @Autowired
    ReservaRepo reservaRepo;

    @Override
    public ReservaOutputDTO addReserva(ReservaInputDTO reservaInputDTO) {
        ReservaEntity reserva = new ReservaEntity(reservaInputDTO);
        reservaRepo.save(reserva);
        ReservaOutputDTO reservaOutputDTO = new ReservaOutputDTO(reserva);
        return reservaOutputDTO;
    }

    @Override
    public ReservaOutputDTO findById(Integer id) throws Exception {
        ReservaEntity re = reservaRepo.findById(id).orElseThrow(() -> new Exception("No se encuentra reserva con ID "+id));
        ReservaOutputDTO reservaOutputDTO = new ReservaOutputDTO(re);
        return re;
    }

    @Override
    public ReservaListaOutputDTO findAll() {
        return null;
    }

    @Override
    public ReservaListaOutputDTO findByCiudadDestino() {
        return null;
    }

}

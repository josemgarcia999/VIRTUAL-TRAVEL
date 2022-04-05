package com.example.BackEmpresa.Bus.application;

import com.example.BackEmpresa.Bus.domain.BusEntity;
import com.example.BackEmpresa.Bus.infraestructure.controller.dto.output.BusOutputDto;
import com.example.BackEmpresa.Bus.infraestructure.repository.BusRepo;

import com.example.BackEmpresa.shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusService implements IBus{

    @Autowired
    BusRepo reservasRealizadas;

    @Override
    public List<BusOutputDto> findAll() {
        List<BusEntity> reservaEntities = reservasRealizadas.findAll();
        List<BusOutputDto> reservaOutputDTOList = new ArrayList<>();
        for(BusEntity be: reservaEntities){
            BusOutputDto busOutputDto = new BusOutputDto(be);
            reservaOutputDTOList.add(busOutputDto);
        }
        return reservaOutputDTOList;
    }

    @Override
    public BusOutputDto findById(Integer id) throws Exception {
        BusEntity reservaRealizada = reservasRealizadas.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado Bus con ID "+id));
        BusOutputDto busOutputDto = new BusOutputDto(reservaRealizada);
        return busOutputDto;
    }

    @Override
    public BusOutputDto findByCiudadDestino(String ciudadDestino) {

            BusEntity reservaRealizada = reservasRealizadas.findByCiudadDestino(ciudadDestino);
            BusOutputDto busOutputDto = new BusOutputDto(reservaRealizada);
            return busOutputDto;

    }

    @Override
    public void deleteById(Integer id) {
        reservasRealizadas.deleteById(id);

    }

    @Override
    public void deleteAll() {
        reservasRealizadas.deleteAll();
    }


}

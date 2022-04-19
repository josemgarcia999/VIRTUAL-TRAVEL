package com.example.BackEmpresa.Bus.application;

import com.example.BackEmpresa.Bus.domain.BusEntity;
import com.example.BackEmpresa.Bus.infraestructure.controller.dto.output.BusListaOutputDto;
import com.example.BackEmpresa.Bus.infraestructure.controller.dto.output.BusOutputDto;
import com.example.BackEmpresa.Bus.infraestructure.repository.BusRepo;

import com.example.BackEmpresa.shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BusService implements IBus{

    @Autowired
    BusRepo reservasRealizadas;

    @Override
    public BusListaOutputDto findAll() {
        BusListaOutputDto listaBuses = new BusListaOutputDto();
        List<BusEntity> reservaEntities = reservasRealizadas.findAll();
        List<BusOutputDto> reservaOutputDTOList = new ArrayList<>();
        for(BusEntity be: reservaEntities){
            BusOutputDto busOutputDto = new BusOutputDto(be);
            reservaOutputDTOList.add(busOutputDto);
        }
        listaBuses.setBusOutputDtoList(reservaOutputDTOList);
        return listaBuses;
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
    @Override
    public String obtenerCapacidadViaje(String ciudadDestino, Date fechaViaje, Float horaViaje) {
        BusEntity bus= reservasRealizadas.findByCiudadDestinoAndHoraAndFecha(ciudadDestino,horaViaje,fechaViaje);
        if(bus==null){
            return "El viaje no existe";
       } else{
            if(bus.getCapacidad() == 0){
                return "El viaje con destino a "+bus.getCiudadDestino()+ "+ no tiene plazas disponibles. Está lleno.";
            }
            return "Hay "+bus.getCapacidad()+" plazas disponibles para este viaje.";
        }
    }

}

package com.example.BackWeb.Reserva.application;

import com.example.BackWeb.Bus.domain.BusEntity;
import com.example.BackWeb.Bus.infraestructure.repository.BusRepo;
import com.example.BackWeb.Reserva.domain.ReservaEntity;
import com.example.BackWeb.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import com.example.BackWeb.Reserva.infraestructure.controller.dto.output.ReservaListaOutputDTO;
import com.example.BackWeb.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import com.example.BackWeb.Reserva.infraestructure.repository.ReservaRepo;
import com.example.BackWeb.shared.kafka.KafkaMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService implements IReserva{

    @Autowired
    ReservaRepo reservaRepo;

    @Autowired
    BusRepo reservasDisponiblesRepo;


    @Autowired
    KafkaMessageProducer kafkaMessageProducer;



    @Override//reservainputdto se corresponde con el mensaje asincrono de kafka que vamos a enviar desde backweb
    public ReservaOutputDTO realizarReserva(ReservaInputDTO reservaInputDTO) {
        kafkaMessageProducer.sendMessage("mytopic_1",reservaInputDTO);
        ReservaEntity reserva = new ReservaEntity(reservaInputDTO);
        BusEntity reservaDisponible=reservasDisponiblesRepo.findByCiudadDestinoAndHoraAndFecha(reserva.getCiudadDestino(),reserva.getHoraReserva(),reserva.getFechaReserva());
        if(reservaDisponible!= null){
            if(reservaDisponible.getCapacidad()>0){
                reservaDisponible.setCapacidad(reservaDisponible.getCapacidad()-1);
                reservasDisponiblesRepo.save(reservaDisponible);
                reserva.setEstado("ACEPTADA");
            }else{
                reserva.setEstado("CANCELADA");
            }
        }else{
            BusEntity nuevaReserva = new BusEntity(reserva.getCiudadDestino(),reserva.getHoraReserva(),reserva.getFechaReserva());
            reservasDisponiblesRepo.save(nuevaReserva);
            reserva.setEstado("ACEPTADA");
        }
        reservaRepo.save(reserva);
        ReservaOutputDTO reservaOutputDTO = new ReservaOutputDTO(reserva);
        return reservaOutputDTO;
    }

    @Override
    public ReservaOutputDTO findById(Integer id) throws Exception {
        ReservaEntity re = reservaRepo.findById(id).orElseThrow(() -> new Exception("No se encuentra reserva con ID "+id));
        ReservaOutputDTO reservaOutputDTO = new ReservaOutputDTO(re);
        return reservaOutputDTO;
    }

    @Override
    public ReservaListaOutputDTO findAll() {
        ReservaListaOutputDTO reservaListaOutputDTO = new ReservaListaOutputDTO();
        List<ReservaEntity> reservaEntities = reservaRepo.findAll();
        List<ReservaOutputDTO> reservaOutputDTOList = new ArrayList<>();
        for(ReservaEntity re: reservaEntities){
            ReservaOutputDTO reservaOutputDTO = new ReservaOutputDTO(re);
            reservaOutputDTOList.add(reservaOutputDTO);
        }
        reservaListaOutputDTO.setReservaOutputDTOList(reservaOutputDTOList);
        return reservaListaOutputDTO;
    }

    @Override
    public ReservaListaOutputDTO findByCiudadDestino(String ciudadDestino) {
        ReservaListaOutputDTO reservaListaOutputDTO = new ReservaListaOutputDTO();
        List<ReservaEntity> reservaEntities = reservaRepo.findByCiudadDestino(ciudadDestino);
        List<ReservaOutputDTO> reservaOutputDTOList = new ArrayList<>();
        for(ReservaEntity re: reservaEntities){
            ReservaOutputDTO reservaOutputDTO = new ReservaOutputDTO(re);
            reservaOutputDTOList.add(reservaOutputDTO);
        }
        reservaListaOutputDTO.setReservaOutputDTOList(reservaOutputDTOList);
        return reservaListaOutputDTO;

    }

    @Override
    public void deleteById(Integer id) {
        reservaRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        reservaRepo.deleteAll();
    }

}

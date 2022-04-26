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
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@EnableScheduling
public class ReservaService implements IReserva {


    private int contadorActualizar = 0;

    @Autowired
    ReservaRepo reservaRepo;

    @Autowired
    BusRepo reservasDisponiblesRepo;


    @Autowired
    KafkaMessageProducer kafkaMessageProducer;

    @Override//reservainputdto se corresponde con el mensaje asincrono de kafka que vamos a enviar desde backweb
    public ReservaOutputDTO realizarReserva(ReservaInputDTO reservaInputDTO) {
        if (reservaRepo.findByCiudadDestinoAndEmailAndFechaReservaAndHoraReserva(reservaInputDTO.getCiudadDestino(), reservaInputDTO.getEmail(), reservaInputDTO.getFechaReserva(), reservaInputDTO.getHoraReserva()) == null) {
            ReservaEntity reserva = new ReservaEntity(reservaInputDTO);
            BusEntity reservaDisponible = reservasDisponiblesRepo.findByCiudadDestinoAndHoraAndFecha(reserva.getCiudadDestino(), reserva.getHoraReserva(), reserva.getFechaReserva());
            if (reservaDisponible != null) {
                if (reservaDisponible.getCapacidad() > 0) {
                    reservaDisponible.setCapacidad(reservaDisponible.getCapacidad() - 1);
                    reservasDisponiblesRepo.saveAndFlush(reservaDisponible);
                    reserva.setEstado("ACEPTADA");
                    reserva.setBusAsignado(reservaDisponible);
                } else {
                    reserva.setEstado("CANCELADA");
                }
            } else {
                BusEntity nuevaReserva = new BusEntity(reserva.getCiudadDestino(), reserva.getHoraReserva(), reserva.getFechaReserva());
                nuevaReserva.setCapacidad(nuevaReserva.getCapacidad()-1);
                reservasDisponiblesRepo.saveAndFlush(nuevaReserva);
                reserva.setBusAsignado(nuevaReserva);
                reserva.setEstado("ACEPTADA");
            }
            reservaRepo.saveAndFlush(reserva);
            ReservaOutputDTO reservaOutputDTO = new ReservaOutputDTO(reserva);
            kafkaMessageProducer.sendMessage("mytopic_1",reservaInputDTO);
            return reservaOutputDTO;
        } else {
            return null;
        }
    }

    @Override
    public ReservaOutputDTO findById(Integer id) throws Exception {
        ReservaEntity re = reservaRepo.findById(id).orElseThrow(() -> new Exception("No se encuentra reserva con ID " + id));
        ReservaOutputDTO reservaOutputDTO = new ReservaOutputDTO(re);
        return reservaOutputDTO;
    }

    @Override
    public ReservaListaOutputDTO findAll() {
        ReservaListaOutputDTO reservaListaOutputDTO = new ReservaListaOutputDTO();
        List<ReservaEntity> reservaEntities = reservaRepo.findAll();
        List<ReservaOutputDTO> reservaOutputDTOList = new ArrayList<>();
        for (ReservaEntity re : reservaEntities) {
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
        for (ReservaEntity re : reservaEntities) {
            ReservaOutputDTO reservaOutputDTO = new ReservaOutputDTO(re);
            reservaOutputDTOList.add(reservaOutputDTO);
        }
        reservaListaOutputDTO.setReservaOutputDTOList(reservaOutputDTOList);
        return reservaListaOutputDTO;

    }

    @Override
    public void deleteById(Integer id) {
        BusEntity bus = reservaRepo.getById(id).getBusAsignado();
        reservaRepo.deleteById(id);
        if(bus.getReservasAsignadas().size() == 0){
            reservasDisponiblesRepo.deleteById(bus.getId());
        }else{
            bus.setCapacidad(bus.getCapacidad() + 1);
        }
        reservasDisponiblesRepo.flush();

    }

    @Override
    public void deleteAll() {
        reservaRepo.deleteAll();
    }
//
//    @Scheduled(fixedDelay = 60000) //Tiempo que queramos que actualice
//    public void actualizarWebs() {
//        Date fechaActual = new Date(System.currentTimeMillis());
//        List<ReservaEntity> reservas = reservaRepo.findByFechaReservaGreaterThan(fechaActual);
//        if (reservas != null) {
//            for (int i = 0; i < reservas.size(); i++) {//convertir reservaEntity a reservaInput?
//                ReservaInputDTO res = new ReservaInputDTO(reservas.get(i));
//                kafkaMessageProducer.sendMessageTopic2("mytopic_2", res);
//            }
//        }
//        System.out.println("Actualizacion realizada.");
//    }

}
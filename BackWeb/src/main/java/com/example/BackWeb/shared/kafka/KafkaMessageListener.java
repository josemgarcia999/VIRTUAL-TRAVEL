package com.example.BackWeb.shared.kafka;

import com.example.BackWeb.Bus.domain.BusEntity;
import com.example.BackWeb.Bus.infraestructure.repository.BusRepo;
import com.example.BackWeb.Reserva.application.IReserva;
import com.example.BackWeb.Reserva.domain.ReservaEntity;
import com.example.BackWeb.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import com.example.BackWeb.Reserva.infraestructure.repository.ReservaRepo;
import com.example.BackWeb.shared.kafka.Deserializer.ReservaOutputDtoDeserializer;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class KafkaMessageListener {

    ReservaOutputDtoDeserializer reservaOutputDtoDeserializer = new ReservaOutputDtoDeserializer();

    @Autowired
    IReserva reservaService;

    @Autowired
    ReservaRepo reservaRepo;

    @Autowired
    BusRepo reservasDisponiblesRepo;

    @Transactional
    @KafkaListener(topics = "${message.topic.name2:kafkatopic2}", groupId = "${message.group.name:kafkagroup2}")
    public void listenTopic2(ReservaInputDTO reserva) {
        if (!reserva.getNombre().equalsIgnoreCase("borrado")) {
            System.out.println("Reserva recibida en topico 2");
            System.out.println(reserva.toString());
            System.out.println("Objeto deserializado correctamente");
            reservaService.realizarReserva(reserva);
        } else {
            ReservaEntity borrada = reservaRepo.findByCiudadDestinoAndEmailAndFechaReservaAndHoraReserva(reserva.getCiudadDestino(), reserva.getEmail(), reserva.getFechaReserva(), reserva.getHoraReserva());
            if (borrada != null) {
                BusEntity bus = borrada.getBusAsignado();
                reservaRepo.deleteById(borrada.getId());
                reservaRepo.flush();
                int tamReservas = bus.getReservasAsignadas().size();
                if (bus.getReservasAsignadas().size() == 0) {
                    reservasDisponiblesRepo.deleteById(bus.getId());
                } else {
                    bus.setCapacidad(bus.getCapacidad() + 1);
                }
                reservasDisponiblesRepo.flush();

            }
        }

    }


    @KafkaListener(topics = "${message.topic.name:kafkatopic}", groupId = "${message.group.name:kafkagroup}")
    public void listenTopic1(ReservaInputDTO reserva) {

        System.out.println("Reserva recibida en topico 1");
        System.out.println(reserva.toString());
        System.out.println("Objeto deserializado correctamente");
        reservaService.realizarReserva(reserva);
    }

}
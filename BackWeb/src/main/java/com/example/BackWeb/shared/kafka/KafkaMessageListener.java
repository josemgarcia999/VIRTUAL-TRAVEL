package com.example.BackWeb.shared.kafka;

import com.example.BackWeb.Reserva.application.IReserva;
import com.example.BackWeb.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import com.example.BackWeb.shared.kafka.Deserializer.ReservaOutputDtoDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageListener {

    ReservaOutputDtoDeserializer reservaOutputDtoDeserializer = new ReservaOutputDtoDeserializer();

    @Autowired
    IReserva reservaService;

    @KafkaListener(topics = "${message.topic.name2:kafkatopic2}", groupId = "${message.group.name:kafkagroup2}")
    public void listenTopic2(ReservaInputDTO reserva) {
        System.out.println("Reserva recibida en topico 2");
        System.out.println(reserva.toString());
        System.out.println("Objeto deserializado correctamente");
        reservaService.realizarReserva(reserva);
    }
    @KafkaListener(topics = "${message.topic.name:kafkatopic}", groupId = "${message.group.name:kafkagroup}")
    public void listenTopic1(ReservaInputDTO reserva) {
        System.out.println("Reserva recibida en topico 1");
        System.out.println(reserva.toString());
        System.out.println("Objeto deserializado correctamente");
        reservaService.realizarReserva(reserva);
    }

}
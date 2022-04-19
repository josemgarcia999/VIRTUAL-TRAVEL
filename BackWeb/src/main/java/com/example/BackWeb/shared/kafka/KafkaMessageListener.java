package com.example.BackWeb.shared.kafka;

import com.example.BackWeb.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import com.example.BackWeb.shared.kafka.Deserializer.ReservaOutputDtoDeserializer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageListener {

    ReservaOutputDtoDeserializer reservaOutputDtoDeserializer = new ReservaOutputDtoDeserializer();

    @KafkaListener(topics = "${message.topic.name:kafkatopic}", groupId = "${message.group.name:kafkagroup}")
    public void listenTopic1(ReservaInputDTO reserva) {
        System.out.println("Reserva recibida");
        System.out.println(reserva.toString());
        System.out.println("Objeto deserializado correctamente");

    }

}
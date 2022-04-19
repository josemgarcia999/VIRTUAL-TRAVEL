package com.example.BackEmpresa.shared.kafka;

import com.example.BackEmpresa.Reserva.application.IReserva;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import com.example.BackEmpresa.shared.kafka.Deserializer.ReservaOutputDtoDeserializer;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class KafkaMessageListener {

    ReservaOutputDtoDeserializer reservaOutputDtoDeserializer = new ReservaOutputDtoDeserializer();

    @Autowired
    IReserva reservaService;

    @KafkaListener(topics = "${message.topic.name:kafkatopic}", groupId = "${message.group.name:kafkagroup}")
    public void listenTopic1(ReservaInputDTO reserva) {
        System.out.println("Reserva recibida");
        System.out.println(reserva.toString());
        reservaService.realizarReserva(reserva);
        System.out.println("Objeto deserializado correctamente");

    }

}
package com.example.BackEmpresa.shared.kafka;


import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaTestController {

    @Autowired
    KafkaMessageProducer kafkaMessageProducer;

    @PostMapping("/add/{topic}")
    public void addIdCustomer(@PathVariable String topic, @RequestBody ReservaInputDTO body)
    {
        kafkaMessageProducer.sendMessageTopic1(topic,body);
    }

}

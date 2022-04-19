package com.example.BackEmpresa.shared.kafka;

import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaMessageProducer {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    //@Value(value = "${message.topic.name:kafkatopic}")
    private String topicName;

    public void sendMessage(String topic, ReservaInputDTO objeto) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, objeto);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onSuccess(SendResult<String, Object> result) {
                System.out.println("Reserva enviada al topico "+ topic + " with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {System.err.println("Mensaje no enviado");
            }
        });
    }
}
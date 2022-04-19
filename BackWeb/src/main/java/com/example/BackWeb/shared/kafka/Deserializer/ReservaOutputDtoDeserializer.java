package com.example.BackWeb.shared.kafka.Deserializer;

import com.example.BackWeb.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;


public class ReservaOutputDtoDeserializer implements Deserializer<ReservaInputDTO> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public ReservaInputDTO deserialize(String s, byte[] reservabytes) {
        ObjectMapper mapper = new ObjectMapper();
        ReservaInputDTO reservaInputDTO = null;
        try {
            reservaInputDTO = mapper.readValue(reservabytes, ReservaInputDTO.class);
            System.out.println("He entrado en mapper");
        } catch (Exception e) {

            e.printStackTrace();
        }
        return reservaInputDTO;
    }

    @Override
    public ReservaInputDTO deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }

}
package com.example.BackEmpresa.shared.kafka.Deserializer;

import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;
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
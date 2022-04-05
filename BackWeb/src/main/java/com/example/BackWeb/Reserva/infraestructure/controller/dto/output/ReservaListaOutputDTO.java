package com.example.BackWeb.Reserva.infraestructure.controller.dto.output;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class ReservaListaOutputDTO {
    private List<ReservaOutputDTO> reservaOutputDTOList;
}

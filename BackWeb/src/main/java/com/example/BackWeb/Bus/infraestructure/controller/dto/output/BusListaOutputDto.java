package com.example.BackWeb.Bus.infraestructure.controller.dto.output;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class BusListaOutputDto {
    private List<BusOutputDto> busOutputDtoList;

}

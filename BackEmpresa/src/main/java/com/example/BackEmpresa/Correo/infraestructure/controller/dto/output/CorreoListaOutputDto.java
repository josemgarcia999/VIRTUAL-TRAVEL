package com.example.BackEmpresa.Correo.infraestructure.controller.dto.output;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class CorreoListaOutputDto {
    private List<CorreoOutputDto> correoOutputDtoList;
}

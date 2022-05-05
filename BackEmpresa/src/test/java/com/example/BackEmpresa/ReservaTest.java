package com.example.BackEmpresa;


import com.example.BackEmpresa.Reserva.application.ReservaService;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaListaOutputDTO;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import com.example.BackEmpresa.Reserva.infraestructure.repository.ReservaRepo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = BackEmpresaApplication.class)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReservaTest {

    @Autowired
    ReservaService reservaService;


    @BeforeAll
    void inicializar(){
        Date date = new Date(2022-04-29);
        Float hora = Float.valueOf(8);
        ReservaInputDTO reservaInputDTO = new ReservaInputDTO("Madrid","Paco","Garcia","6666666666","josemanuel.garcia@bosonit.com",date,hora);
        ReservaInputDTO reservaInputDTO2 = new ReservaInputDTO("Barcelona","Jose","Garcia","6666666666","josem@it.com",date,hora);

        reservaService.realizarReserva(reservaInputDTO);
        reservaService.realizarReserva(reservaInputDTO2);
    }


    @Test
    void realizarReserva(){
        Date date = new Date(2022-04-29);
        Float hora = Float.valueOf(8);
        ReservaInputDTO reservaInputDTO = new ReservaInputDTO("Madrid","Juan","Garcia","6666666666","josem@it.com",date,hora);
        reservaService.realizarReserva(reservaInputDTO);
        assertEquals(3,reservaService.findAll().getReservaOutputDTOList().size());
    }

    @Test
    void realizarReservaExistente(){
        Date date = new Date(2022-04-29);
        Float hora = Float.valueOf(8);
        ReservaInputDTO reservaInputDTO = new ReservaInputDTO("Madrid","Paco","Garcia","6666666666","josemanuel.garcia@bosonit.com",date,hora);

        ReservaOutputDTO reservaOutputDTO = reservaService.realizarReserva(reservaInputDTO);
        assertNull(reservaOutputDTO);
    }

    @Test
    void findByIdTest() throws Exception {

        assertEquals("Madrid",reservaService.findById(1).getCiudadDestino());

    }
    @Test
    void findAllTest(){
        assertEquals(2,reservaService.findAll().getReservaOutputDTOList().size());
    }

    @Test
    void findByCiudadDestinoTest(){
        assertEquals(1,reservaService.findByCiudadDestino("Barcelona").getReservaOutputDTOList().size());
    }
    @Test
    @Transactional
    void deleteByIdTest() throws Exception {
        reservaService.deleteById(1);
        assertEquals(2,reservaService.findAll().getReservaOutputDTOList().size());
    }



    @AfterAll
    void deleteAllTest(){
        reservaService.deleteAll();
        assertEquals(0,reservaService.findAll().getReservaOutputDTOList().size());
    }


}

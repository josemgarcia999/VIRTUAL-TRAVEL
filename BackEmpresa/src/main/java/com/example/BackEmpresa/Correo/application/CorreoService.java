package com.example.BackEmpresa.Correo.application;

import com.example.BackEmpresa.Correo.domain.CorreoEntity;
import com.example.BackEmpresa.Correo.infraestructure.controller.dto.input.CorreoInputDto;
import com.example.BackEmpresa.Correo.infraestructure.controller.dto.output.CorreoListaOutputDto;
import com.example.BackEmpresa.Correo.infraestructure.controller.dto.output.CorreoOutputDto;
import com.example.BackEmpresa.Correo.infraestructure.repository.CorreoRepo;
import com.example.BackEmpresa.Reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import com.example.BackEmpresa.shared.email.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class CorreoService implements ICorreo {

    @Autowired
    CorreoRepo correoRepo;


    @Override
    public void sendEmail(ReservaOutputDTO reservaOutputDTO) {
        final String fromEmail = "virtual.travel.exercise@gmail.com"; //requires valid gmail id
        final String password = "bosonit1"; // correct password for gmail id
        final String toEmail = reservaOutputDTO.getEmail(); // can be any email id

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        CorreoInputDto correoInputDto = new CorreoInputDto(reservaOutputDTO);
        CorreoEntity correo = new CorreoEntity(correoInputDto);
        correoRepo.save(correo);
        Session session = Session.getInstance(props, auth);
        EmailUtil.sendEmail(session, toEmail, "Datos Reserva VIRTUAL_TRAVEL",
                "Los datos de su reserva son los siguientes: " + "\n" +
                        "Ciudad de destino: " + correo.getCiudadDestino() + " " + "\n" +
                        "Fecha de reserva: " + formatter.format(correo.getFechaReserva()) + " " + "\n" +
                        "Hora de reserva: " + correo.getHoraReserva() + " " + "\n" +
                        "Esperemos que disfrute. Muchas gracias por confiar en VIRTUAL_TRAVEL :)"
        );
    }

    @Override
    public CorreoListaOutputDto findCorreoByEmail(String email) {
        List<CorreoEntity> correosEspecificos = correoRepo.findByEmail(email);
        List<CorreoOutputDto> correoOutputDtoList = new ArrayList<>();
        CorreoListaOutputDto correoListaOutputDto = new CorreoListaOutputDto();
        for (CorreoEntity co : correosEspecificos) {
            CorreoOutputDto correoOutputDto = new CorreoOutputDto(co);
            correoOutputDtoList.add(correoOutputDto);
        }
        correoListaOutputDto.setCorreoOutputDtoList(correoOutputDtoList);
        return correoListaOutputDto;
    }


    @Override
    public CorreoListaOutputDto getAllCorreos() {
        List<CorreoEntity> correosEnviados = correoRepo.findAll();
        List<CorreoOutputDto> correoOutputDtoList = new ArrayList<>();
        CorreoListaOutputDto correoListaOutputDto = new CorreoListaOutputDto();
        for (CorreoEntity co : correosEnviados) {
            CorreoOutputDto correoOutputDto = new CorreoOutputDto(co);
            correoOutputDtoList.add(correoOutputDto);
        }
        correoListaOutputDto.setCorreoOutputDtoList(correoOutputDtoList);
        return correoListaOutputDto;
    }


    //METODO DE CONSULTA DE CORREOS ENVIADOS (CIUDAD, FECHA INFERIOR, FECHA SUPERIOR, HORA INFERIOR, HORA SUPERIOR)



}







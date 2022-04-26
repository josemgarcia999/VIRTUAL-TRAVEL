package com.example.BackWeb.shared.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = ReservaInputDTOValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface horaReserva {
    String message() default "{horaReservaValida.mensajePorDefecto}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
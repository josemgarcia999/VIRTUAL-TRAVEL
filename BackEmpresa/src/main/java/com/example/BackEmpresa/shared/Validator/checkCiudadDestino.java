package com.example.BackEmpresa.shared.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = ValorCiudadDestinoValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface checkCiudadDestino {
    String message() default "Destino no disponible";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

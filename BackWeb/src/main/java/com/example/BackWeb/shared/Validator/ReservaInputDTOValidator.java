package com.example.BackWeb.shared.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ReservaInputDTOValidator implements ConstraintValidator<horaReserva, Float> {


    @Override
    public void initialize(horaReserva constraintAnnotation) {
    }
    @Override
    public boolean isValid(Float aFloat, ConstraintValidatorContext constraintValidatorContext) {

        if (aFloat != 8 && aFloat != 12 && aFloat != 16 && aFloat != 20) {
            return false;
        } else {
            return true;
        }
    }
}


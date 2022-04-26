package com.example.BackWeb.shared.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValorCiudadDestinoValidator implements ConstraintValidator<checkCiudadDestino, String> {


    @Override
    public void initialize(checkCiudadDestino constraintAnnotation) {
    }
    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        if (string.equalsIgnoreCase("Valencia") || string.equalsIgnoreCase("Madrid") || string.equalsIgnoreCase("Barcelona") || string.equalsIgnoreCase("Bilbao")) {
            return true;
        } else {
            return false;
        }
    }
}


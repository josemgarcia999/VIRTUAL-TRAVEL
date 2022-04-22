package com.example.BackEmpresa.shared.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class TamListaValidator implements ConstraintValidator <LimitarLista, List> {
    @Override
    public void initialize(LimitarLista constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List list, ConstraintValidatorContext constraintValidatorContext) {
        if(list.size()<2){
            return true;
        }else{
            return false;
        }
    }
}

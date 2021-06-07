package com.condomeasy.backend.validator;

import com.condomeasy.backend.service.IUserService;
import com.condomeasy.backend.validator.annotation.ExistsCPFValidator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckExistsCPFValidator implements ConstraintValidator<ExistsCPFValidator, String> {

    @Autowired
    private IUserService service;

    @Override
    public void initialize(ExistsCPFValidator constraintAnnotation) {
    }

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintContext) {

        Boolean isValid = false;

        if(cpf.isEmpty()) {
            isValid = true;
        }

        if (service.findByCPF(cpf) != null) {
            isValid = false;
        }

        return isValid;
    }

}

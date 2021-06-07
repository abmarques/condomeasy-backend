package com.condomeasy.backend.validator;

import com.condomeasy.backend.exception.BusinessException;
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

        boolean isValid = false;

        if(cpf.isEmpty()) {
            isValid = true;
        }

        try {
            isValid = service.findByCPF(cpf) == null;
        }catch (BusinessException b) {
            isValid = true;
        }

        return isValid;
    }

}

package com.condomeasy.backend.validator;

import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.service.IUserService;
import com.condomeasy.backend.validator.annotation.ExistsEmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CheckExistsEmailvalidator implements ConstraintValidator<ExistsEmailValidator, String> {

    @Autowired
    private IUserService service;

    @Override
    public void initialize(ExistsEmailValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = true;

        try {
            isValid  = service.findByEmail(email) == null;

        }catch (BusinessException b) {
            isValid = true;
        }

        return isValid;
    }

}

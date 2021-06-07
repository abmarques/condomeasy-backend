package com.condomeasy.backend.validator;

import com.condomeasy.backend.service.IUserService;
import com.condomeasy.backend.validator.annotation.ExistsEmailValidator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckExistsEmailvalidator implements ConstraintValidator<ExistsEmailValidator, String> {

    @Autowired
    private IUserService service;

    @Override
    public void initialize(ExistsEmailValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return service.findByEmail(email) == null;
    }
}

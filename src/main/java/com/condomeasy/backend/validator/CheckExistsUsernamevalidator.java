package com.condomeasy.backend.validator;

import com.condomeasy.backend.service.IUserService;
import com.condomeasy.backend.validator.annotation.ExistsUsernameValidator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckExistsUsernamevalidator implements ConstraintValidator<ExistsUsernameValidator, String>  {

    @Autowired
    private IUserService service;

    @Override
    public void initialize(ExistsUsernameValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return service.findByUsername(username) == null;
    }
}

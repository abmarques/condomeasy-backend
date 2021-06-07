package com.condomeasy.backend.validator;

import com.condomeasy.backend.validator.annotation.UsernameValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CheckUsernameValidator implements ConstraintValidator<UsernameValidator, String> {

    @Override
    public void initialize(UsernameValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return true; /*username.matches("^[a-zA-Z][a-zA-Z0-9_-]");*/
    }

}

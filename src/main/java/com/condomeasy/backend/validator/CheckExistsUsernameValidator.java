package com.condomeasy.backend.validator;

import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.service.IUserService;
import com.condomeasy.backend.validator.annotation.ExistsUsernameValidator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CheckExistsUsernameValidator implements ConstraintValidator<ExistsUsernameValidator, String>  {

    @Autowired
    private IUserService service;

    @Override
    public void initialize(ExistsUsernameValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {

        boolean isValid = true;

        try {
            isValid = service.findByUsername(username) == null;
        }catch (BusinessException b) {
            return true;
        }

        return isValid;
    }


}

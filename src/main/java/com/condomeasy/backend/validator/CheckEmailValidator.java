package com.condomeasy.backend.validator;

import com.condomeasy.backend.validator.annotation.EmailValidator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmailValidator implements ConstraintValidator<EmailValidator, String> {

    @Override
    public void initialize(EmailValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException e) {
            return false;
        }

        return true;
    }
}

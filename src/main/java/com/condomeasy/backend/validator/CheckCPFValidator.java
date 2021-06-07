package com.condomeasy.backend.validator;

import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.validator.annotation.CPFValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.InputMismatchException;

public class CheckCPFValidator implements ConstraintValidator<CPFValidator, String> {

    private Boolean isValid = true;

    @Override
    public void initialize(CPFValidator constraintAnnotation) {
    }

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {

        if(cpf.isEmpty()) {
            return true;
        }

        if (cpf.equals("00000000000") || cpf.equals("11111111111")
                || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777")
                || cpf.equals("88888888888") || cpf.equals("99999999999")
                || (cpf.length() != 11))
            throw new BusinessException("CPF inválido.");

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {

            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {

                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48);

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            if (!(dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
                isValid = false;
        } catch (InputMismatchException erro) {
            isValid = false;
        }

        return isValid;
    }
}

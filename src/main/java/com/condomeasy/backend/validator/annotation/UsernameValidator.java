package com.condomeasy.backend.validator.annotation;

import com.condomeasy.backend.validator.CheckUsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.condomeasy.backend.constant.MessageBundle.INVALID_USERNAME;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, ANNOTATION_TYPE })
@Constraint(validatedBy = CheckUsernameValidator.class)
public @interface UsernameValidator {

    String message() default INVALID_USERNAME;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

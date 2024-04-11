package com.example.transactionsproject.customValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidNameValidator.class)
public @interface ValidName {

    public String message() default "Invalid name: Should contain one uppercase letter and not numbers or symbols";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] paylod() default {};
}

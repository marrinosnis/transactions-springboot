package com.example.transactionsproject.customValidator;

import com.example.transactionsproject.exceptions.InvalidNameException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNameValidator implements ConstraintValidator <ValidName, String>{

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {

        if(name == null){
            return false;
        }

        String regexPattern = "^[A-Z][a-zA-Z]*$";

        if(!name.matches(regexPattern)){
            throw new InvalidNameException("Name should not contains numbers and symbols");
        }
        // if the name matches the rules of the regex, it will return true, else false
        return name.matches(regexPattern);
    }
}

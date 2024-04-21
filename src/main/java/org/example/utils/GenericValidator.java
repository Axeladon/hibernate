package org.example.utils;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GenericValidator {
    private final Validator validator;

    public GenericValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public <T> List<String> validate(T entity) {
        List<String> result = new ArrayList<>();
        Set<ConstraintViolation<T>> violations = validator.validate(entity);
        for (ConstraintViolation<T> violation : violations) {
            result.add(violation.getMessage());
        }
        return result;
    }
}

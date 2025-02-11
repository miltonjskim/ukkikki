package com.dancing_orangutan.ukkikki.global.validator;

import com.dancing_orangutan.ukkikki.global.error.ErrorCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public abstract class BaseNameValidator<T extends Annotation> implements ConstraintValidator<T, String> {

    protected int max;
    protected ErrorCode requiredErrorCode;
    protected ErrorCode tooLongErrorCode;

    @Override
    public void initialize(T constraintAnnotation) {
        setUp(constraintAnnotation);
    }
    protected abstract void setUp(T constraintAnnotation);

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context){
        context.disableDefaultConstraintViolation();

        if (s == null || s.trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate(requiredErrorCode.name())
                    .addConstraintViolation();
            return false;
        }

        if (s.length() > max) {
            context.buildConstraintViolationWithTemplate(tooLongErrorCode.name())
                    .addConstraintViolation();
            return false;
        }

        return true;
    }

}

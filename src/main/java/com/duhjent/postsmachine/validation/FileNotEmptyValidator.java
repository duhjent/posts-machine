package com.duhjent.postsmachine.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

public class FileNotEmptyValidator implements ConstraintValidator<FileNotEmpty, MultipartFile> {

    @Override
    public void initialize(FileNotEmpty fileNotEmpty) {
    }

    @Override
    public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
        return !value.isEmpty();
    }

}

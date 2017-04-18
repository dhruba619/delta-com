package com.ionic.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.ionic.repository.ICustomerRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * This annotation is used to validate the uniqueness of email
 * during the regiration process
 */
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if(customerRepository == null){
            return false;
        }
        return null==customerRepository.findByEmail(email);
    }
}

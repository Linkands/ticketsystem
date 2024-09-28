package com.learn.ticketsystem.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailDomainValidator implements ConstraintValidator<EmailDomain, String> {

    private String domain;

    public void initialize(EmailDomain emailDomain) {
        this.domain = emailDomain.domain();
    }

    public boolean isValid(String email, ConstraintValidatorContext context) {
        return email != null && email.endsWith(domain);
    }
}

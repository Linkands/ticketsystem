package com.learn.ticketsystem.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailDomainValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailDomain {
    String message() default "Invalid email domain";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String domain();
}

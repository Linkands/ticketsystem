package com.learn.ticketsystem.exception;

import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { ValidationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidationException(ValidationException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(EntityNotFoundException exception) {
        return exception.getMessage();
    }
}

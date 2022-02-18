package com.api.booksmanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value={ResourceNotFoundException.class})
    public ResponseEntity<CustomException> handleResourceNotFoundException(ResourceNotFoundException e){
        CustomException exception = new CustomException(e.getMessage(), HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(exception,HttpStatus.NO_CONTENT);
    }
}

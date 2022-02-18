package com.api.booksmanagement.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class CustomException {
    private String message;
    private HttpStatus status;
    private LocalDateTime timeStamp;

    public CustomException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
        this.timeStamp = LocalDateTime.now();
    }
}

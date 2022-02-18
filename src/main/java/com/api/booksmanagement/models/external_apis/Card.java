package com.api.booksmanagement.models.external_apis;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Card {
    private String id;
    private LocalDate expiry;
}

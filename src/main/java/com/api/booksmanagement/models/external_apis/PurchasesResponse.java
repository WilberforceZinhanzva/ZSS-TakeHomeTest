package com.api.booksmanagement.models.external_apis;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PurchasesResponse {
    private LocalDate updated;
    private String responseCode;
    private String responseDescription;
    private String reference;
    private String debitReference;
}

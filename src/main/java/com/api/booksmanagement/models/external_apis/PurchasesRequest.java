package com.api.booksmanagement.models.external_apis;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PurchasesRequest {
    private String type;
    private String extendedType;
    private Double amount;
    private String created;
    private String reference;
    private String narration;
    private Map<String,Object> additionalData = new HashMap<>();
    private Card card;
}

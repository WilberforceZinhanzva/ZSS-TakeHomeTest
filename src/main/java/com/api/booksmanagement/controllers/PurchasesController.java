package com.api.booksmanagement.controllers;

import com.api.booksmanagement.models.external_apis.Card;
import com.api.booksmanagement.models.external_apis.PurchasesResponse;
import com.api.booksmanagement.services.PurchasesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchases")
public class PurchasesController {

    private PurchasesService purchasesService;

    public PurchasesController(PurchasesService purchasesService) {
        this.purchasesService = purchasesService;
    }

    @PostMapping("/books/{bookId}")
    public ResponseEntity<PurchasesResponse> makeAPurchase(@PathVariable("bookId") String bookId, @RequestBody Card card){
        return ResponseEntity.ok(purchasesService.purchaseBook(bookId, card));
    }
}

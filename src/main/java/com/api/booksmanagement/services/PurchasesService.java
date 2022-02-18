package com.api.booksmanagement.services;

import com.api.booksmanagement.models.external_apis.Card;
import com.api.booksmanagement.models.external_apis.PurchasesRequest;
import com.api.booksmanagement.models.external_apis.PurchasesResponse;
import com.api.booksmanagement.models.transferables.TransferableBook;
import com.api.booksmanagement.restclients.PurchasesGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PurchasesService {

    private PurchasesGateway purchasesGateway;
    private BookService bookService;

    @Value("${gateways.purchases.token}")
    private String token;

    public PurchasesService(PurchasesGateway purchasesGateway, BookService bookService) {
        this.purchasesGateway = purchasesGateway;
        this.bookService = bookService;
    }



    public PurchasesResponse purchaseBook(String bookId, Card card){
        TransferableBook book = bookService.retrieveBookById(bookId);
        PurchasesRequest purchasesRequest = new PurchasesRequest();
        purchasesRequest.setType("PURCHASE");
        purchasesRequest.setExtendedType("NONE");
        purchasesRequest.setAmount(new BigDecimal(book.getPrice()).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
        purchasesRequest.setCreated(ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        purchasesRequest.setReference("33d0893a-4c0e-49cf-a373-7e67a64ce036");
        purchasesRequest.setNarration("Purchase of book");
        purchasesRequest.setCard(card);

        PurchasesResponse response = purchasesGateway.purchaseBook(purchasesRequest,token);
        return response;
    }
}

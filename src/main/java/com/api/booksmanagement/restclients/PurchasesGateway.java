package com.api.booksmanagement.restclients;

import com.api.booksmanagement.models.external_apis.PurchasesRequest;
import com.api.booksmanagement.models.external_apis.PurchasesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="purchases-gateway",url="https://lab.v.co.zw/interview/api/transaction")
public interface PurchasesGateway {

    @PostMapping(consumes = "application/json",produces="application/json")
    PurchasesResponse purchaseBook(@RequestBody PurchasesRequest purchasesRequest,@RequestHeader("Authorization") String token);
}

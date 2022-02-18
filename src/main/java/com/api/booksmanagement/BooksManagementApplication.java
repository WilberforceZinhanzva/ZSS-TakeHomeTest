package com.api.booksmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BooksManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksManagementApplication.class, args);
    }

}

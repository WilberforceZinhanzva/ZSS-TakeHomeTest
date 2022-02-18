package com.api.booksmanagement.controllers;

import com.api.booksmanagement.models.consumables.ConsumableBook;
import com.api.booksmanagement.models.transferables.TransferableBook;
import com.api.booksmanagement.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<TransferableBook> saveBook(@RequestBody ConsumableBook consumableBook){
        return ResponseEntity.ok(bookService.saveBook(consumableBook));
    }

    @GetMapping
    public ResponseEntity<List<TransferableBook>> retrieveAllBooks(){
        return ResponseEntity.ok(bookService.retrieveAllBooks());
    }

    @GetMapping("/in-category")
    public ResponseEntity<List<TransferableBook>> retrieveAllBooksByCategory(@RequestParam String category){
        return ResponseEntity.ok(bookService.retrieveBooksByCategory(category));
    }
}

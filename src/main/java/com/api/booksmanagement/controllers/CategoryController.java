package com.api.booksmanagement.controllers;

import com.api.booksmanagement.models.consumables.ConsumableCategory;
import com.api.booksmanagement.models.transferables.TransferableCategory;
import com.api.booksmanagement.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<TransferableCategory> saveCategory(@RequestBody ConsumableCategory consumableCategory){
        return ResponseEntity.ok(categoryService.saveCategory(consumableCategory));
    }

    @GetMapping
    public ResponseEntity<List<TransferableCategory>> retrieveAllCategories(){
        return ResponseEntity.ok(categoryService.retrieveAllCategories());
    }
}

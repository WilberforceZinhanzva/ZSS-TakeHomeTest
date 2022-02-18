package com.api.booksmanagement.services;

import com.api.booksmanagement.models.consumables.ConsumableCategory;
import com.api.booksmanagement.models.entities.Category;
import com.api.booksmanagement.models.transferables.TransferableCategory;
import com.api.booksmanagement.repositories.CategoryRepository;
import com.api.booksmanagement.util.Utilities;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public TransferableCategory saveCategory(ConsumableCategory consumable){
        Category category = new Category();
        category.setId(Utilities.generatedId());
        category.setTitle(consumable.getTitle());
        return categoryRepository.save(category).serializeForTransfer();
    }

    public List<TransferableCategory> retrieveAllCategories(){
        return categoryRepository.findAll().stream().map(Category::serializeForTransfer).collect(Collectors.toList());
    }
}

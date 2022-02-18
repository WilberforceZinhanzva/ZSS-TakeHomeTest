package com.api.booksmanagement.repositories;

import com.api.booksmanagement.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,String> {
    Optional<Category> findByTitle(String title);
}

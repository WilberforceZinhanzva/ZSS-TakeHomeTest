package com.api.booksmanagement.services;

import com.api.booksmanagement.exceptions.ResourceNotFoundException;
import com.api.booksmanagement.models.consumables.ConsumableBook;
import com.api.booksmanagement.models.entities.Book;
import com.api.booksmanagement.models.entities.Category;
import com.api.booksmanagement.models.transferables.TransferableBook;
import com.api.booksmanagement.repositories.BookRepository;
import com.api.booksmanagement.repositories.CategoryRepository;
import com.api.booksmanagement.util.Utilities;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;

    public BookService(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    public TransferableBook saveBook(ConsumableBook consumableBook){
        Optional<Category> category = categoryRepository.findByTitle(consumableBook.getCategory());
        if(category.isEmpty())
            throw new ResourceNotFoundException("Category "+ consumableBook.getCategory() + " not found!");
        Book book = new Book();
        book.setId(Utilities.generatedId());
        book.setTitle(consumableBook.getTitle());
        book.setCategory(category.get());
        book.setDescription(consumableBook.getDescription());
        book.setPrice(Utilities.roundToTwoDecimals(consumableBook.getPrice()));

        return bookRepository.save(book).serializeForTransfer();
    }

    public TransferableBook retrieveBookById(String id){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isEmpty())
            throw new ResourceNotFoundException("Book not found!");
        return book.get().serializeForTransfer();
    }
    public List<TransferableBook> retrieveAllBooks(){
        List<Book> books = bookRepository.findAll();
        return books.stream().map(Book::serializeForTransfer).collect(Collectors.toList());
    }

    public List<TransferableBook> retrieveBooksByCategory(String category){
        List<Book> books = bookRepository.findByCategory_Title(category);
        return books.stream().map(Book::serializeForTransfer).collect(Collectors.toList());
    }


}

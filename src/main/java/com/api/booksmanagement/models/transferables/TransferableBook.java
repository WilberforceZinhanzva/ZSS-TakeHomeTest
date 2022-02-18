package com.api.booksmanagement.models.transferables;

import com.api.booksmanagement.models.entities.Book;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public class TransferableBook implements Transferable{
    private String id;
    private String title;
    private String description;
    private String price;
    private TransferableCategory category;

    public TransferableBook(Book book){
        this.id = book.getId();
        this.title = book.getTitle();
        this.description = book.getDescription();
        this.price = book.getPrice();
        this.category = book.getCategory().serializeForTransfer();
    }
}

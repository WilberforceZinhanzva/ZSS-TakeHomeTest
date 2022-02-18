package com.api.booksmanagement.models.transferables;

import com.api.booksmanagement.models.entities.Category;
import lombok.Data;

@Data
public class TransferableCategory implements Transferable{
    private String id;
    private String title;

    public TransferableCategory(Category category){
        this.id = category.getId();
        this.title = category.getTitle();
    }
}

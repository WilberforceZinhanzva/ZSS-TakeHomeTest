package com.api.booksmanagement.models.entities;

import com.api.booksmanagement.models.transferables.TransferableCategory;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="categories")
public class Category implements SerializableEntity{
    @Id
    private String id;
    @Column(unique = true)
    private String title;
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    @Override
    public TransferableCategory serializeForTransfer() {
        return new TransferableCategory(this);
    }
}

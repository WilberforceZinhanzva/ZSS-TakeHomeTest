package com.api.booksmanagement.models.entities;

import com.api.booksmanagement.models.transferables.TransferableBook;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="books")
public class Book implements SerializableEntity {
    @Id
    private String id;
    @Column(nullable=false,unique = true)
    private String title;
    @Column(nullable = false)
    private String description;
    private String price;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="category")
    private Category category;

    @Override
    public TransferableBook serializeForTransfer() {
        return new TransferableBook(this);
    }
}

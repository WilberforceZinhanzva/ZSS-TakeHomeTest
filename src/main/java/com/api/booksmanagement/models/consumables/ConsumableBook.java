package com.api.booksmanagement.models.consumables;

import lombok.Data;

@Data
public class ConsumableBook implements Consumable{
    private String title;
    private String description;
    private Double price;
    private String category;

}

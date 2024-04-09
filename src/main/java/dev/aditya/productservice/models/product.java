package dev.aditya.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class product {
    private Long id;
    private String title;
    private String description;
    private double price;
    private category category;
    private String imageUrl;
}

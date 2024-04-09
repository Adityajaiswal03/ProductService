package dev.aditya.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class product {
    @Id
    private Long id;
    private String title;
    private String description;
    private double price;
    @ManyToOne
    private category category;
    private String imageUrl;
}

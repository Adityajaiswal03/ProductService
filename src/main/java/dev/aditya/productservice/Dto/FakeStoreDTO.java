package dev.aditya.productservice.Dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreDTO {
    private Long id;
    private String title;
    private String description;
    private String category;
    private String image;
    private double price;
}

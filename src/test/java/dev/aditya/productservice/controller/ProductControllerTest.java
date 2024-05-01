package dev.aditya.productservice.controller;

import dev.aditya.productservice.models.Product;
import dev.aditya.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;
    @MockBean
    private ProductService productService;
    @Test
    void TestValidProductId() {
        // Mock the productService method
        Product product=new Product();
        product.setId(1L);
        product.setTitle("Iphone 15");
        product.setPrice(1000.0);
        when(productService.getProductById(1L))
                .thenReturn(product);
        Product outputProduct= productController.getProductById(1L);
        assertEquals(product,outputProduct,"The Product is not the same");
    }
    @Test
    void TestInvalidProductId() {
    }
    @Test
    void getProducts() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void createProduct() {
    }
}
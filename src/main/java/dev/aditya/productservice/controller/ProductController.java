package dev.aditya.productservice.controller;
import dev.aditya.productservice.Dto.FakeStoreDTO;
import dev.aditya.productservice.services.ProductService;
import dev.aditya.productservice.models.Product;
import org.springframework.web.bind.annotation.*;

import  java.util.*;

@RestController
public class ProductController {
    public ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/hi")
    public String sayHello() {

        return "Hello, World";
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }
    @GetMapping("/products")
    public List<Product> getProducts(){

        return productService.getProducts();
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id,@RequestBody Product product) {
        System.out.println(product.getTitle());
        return productService.updateProduct(id,product);
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

}

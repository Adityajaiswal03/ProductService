package dev.aditya.productservice.services;
import java.util.*;

import dev.aditya.productservice.Dto.FakeStoreDTO;
import dev.aditya.productservice.models.Product;
public interface ProductService {
    Product getProductById(Long id);
    List<Product> getProducts();
    Product updateProduct(Long id, Product product);
    public Product createProduct(Product product);

}

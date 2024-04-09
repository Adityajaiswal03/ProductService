package dev.aditya.productservice.services;
import java.util.*;

import dev.aditya.productservice.Dto.FakeStoreDTO;
import dev.aditya.productservice.models.product;
public interface ProductService {
    product getProductById(Long id);
    List<FakeStoreDTO> getProducts();
    FakeStoreDTO updateProduct(Long id, FakeStoreDTO product);
}

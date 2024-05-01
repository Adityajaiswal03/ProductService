package dev.aditya.productservice.services;

import dev.aditya.productservice.Dto.FakeStoreDTO;
import dev.aditya.productservice.exceptions.CategoryNotFoundException;
import dev.aditya.productservice.exceptions.ProductNotFoundException;
import dev.aditya.productservice.models.Category;
import dev.aditya.productservice.models.Product;
import dev.aditya.productservice.repositories.CategoryRepository;
import dev.aditya.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
@Primary
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id){
       Optional<Product> optionalproduct= productRepository.findById(id);
        if (optionalproduct.isEmpty()) {
            throw new ProductNotFoundException(id, "Product not found");
        }

        return optionalproduct.get();
    }
    @Override
    public List<Product> getProducts(){
        return null;
    }
    @Override
    public Product updateProduct(Long id, Product product){
        return null;
    }
    @Override
    public Product createProduct(Product product){
        Category category = product.getCategory();

        if (category.getId() == null) { // save the category
            product.setCategory(categoryRepository.save(category));
        }

        Product product1 = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        if(optionalCategory.isEmpty()) {
            throw new CategoryNotFoundException("Category not found");
        }
        product1.setCategory(optionalCategory.get());
        return product1;
    }
}

package dev.aditya.productservice.services;
import dev.aditya.productservice.Dto.FakeStoreDTO;
import dev.aditya.productservice.exceptions.ProductNotFoundException;
import dev.aditya.productservice.models.Category;
import dev.aditya.productservice.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class  FakeStoreService implements ProductService{
    private RestTemplate restTemplate=new RestTemplate();

    public Product getProductById(Long id) {
        FakeStoreDTO fakeStoreDTO=restTemplate.getForObject("https://fakestoreapi.com/products"+id,FakeStoreDTO.class);
        Product product=new Product();
        if (fakeStoreDTO == null) {
            throw new ProductNotFoundException(id, "Please pass a valid productId");
        }
        return convertFakeStoreProductDtoToProduct(fakeStoreDTO);
    }
    public List<Product> getProducts() {
        FakeStoreDTO[] products= restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreDTO[].class);
        Product[] product=new Product[products.length];
        for(int i=0;i<products.length;i++){
            product[i]=convertFakeStoreProductDtoToProduct(products[i]);

        }
        return Arrays.stream(product).toList();
    }
    public Product updateProduct(Long id, Product product){
         restTemplate.put("https://fakestoreapi.com/products/"+id, product);
         return null;
    }
    @Override
    public Product createProduct(Product product) {
        return null;
    }
    private Product convertFakeStoreProductDtoToProduct(FakeStoreDTO fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category = new Category();
        product.setCategory(category);

        return product;
    }
}

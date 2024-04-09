package dev.aditya.productservice.services;
import dev.aditya.productservice.Dto.FakeStoreDTO;
import dev.aditya.productservice.models.category;
import dev.aditya.productservice.models.product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class  FakeStoreService implements ProductService{
    private RestTemplate restTemplate=new RestTemplate();

    public product getProductById(Long id) {
        FakeStoreDTO fakeStoreDTO=restTemplate.getForObject("https://fakestoreapi.com/products"+id,FakeStoreDTO.class);
        product product=new product();

        product.setId(fakeStoreDTO.getId());
        product.setTitle(fakeStoreDTO.getTitle());
        product.setDescription(fakeStoreDTO.getDescription());
        product.setPrice(fakeStoreDTO.getPrice());
        product.setImageUrl(fakeStoreDTO.getImage());
        product.setCategory(new category());
        return  product;
    }
    public List<FakeStoreDTO> getProducts() {
        FakeStoreDTO[] products= restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreDTO[].class);
        return Arrays.stream(products).toList();
    }
    public FakeStoreDTO updateProduct(Long id, FakeStoreDTO product){
         restTemplate.put("https://fakestoreapi.com/products/"+id, product);
         return product;
    }

}

package dev.aditya.productservice.controller;
import dev.aditya.productservice.Dto.ExceptionDto;
import dev.aditya.productservice.Dto.FakeStoreDTO;
import dev.aditya.productservice.services.FakeStoreService;
import dev.aditya.productservice.services.ProductService;
import  dev.aditya.productservice.models.product;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.FileAlreadyExistsException;
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
    public product getProductById(@PathVariable("id") Long id) {
//        ResponseEntity<product> responseEntity=null;
//        product product=new product();
//        try{
//            product= productService.getProductById(id);
//            responseEntity=new ResponseEntity<>(product, HttpStatus.OK);
//            return responseEntity;
//        }catch(RuntimeException exception){
//            ExceptionDto dto=new ExceptionDto();
//            dto.setMessage("Something went wrong");
//            dto.setResolution("Enter valid Id");
//            ResponseEntity<ExceptionDto> response=new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);
//            return response;
//        }
        return productService.getProductById(id);
    }
    @GetMapping("/products")
    public List<FakeStoreDTO> getProducts(){
//        try{
//            List<FakeStoreDTO> products= productService.getProducts();
//            ResponseEntity<List<FakeStoreDTO>> responseEntity=new ResponseEntity<>(products,HttpStatus.OK);
//            return responseEntity;
//        }catch(RuntimeException exception){
//            ExceptionDto dto=new ExceptionDto();
//            dto.setResolution("Enter valid entity");
//            dto.setMessage("Soemthing went wrong");
//            ResponseEntity<ExceptionDto> response=new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);
//            return response;
//        }
        return productService.getProducts();
    }

    @PutMapping("/products/{id}")
    public FakeStoreDTO updateProduct(@PathVariable Long id,@RequestBody FakeStoreDTO product) {
        System.out.println(product.getTitle());
        return productService.updateProduct(id,product);
    }

}

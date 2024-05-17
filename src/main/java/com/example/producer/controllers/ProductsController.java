package com.example.producer.controllers;

import com.example.producer.model.Product;
import com.example.producer.service.ProductsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok().body(productsService.getAllProducts());
    }

    @PostMapping("/check")
    public ResponseEntity<?> getProductByName(@RequestBody Product product){
        Optional<Product> foundProduct = productsService.getProductByName(product);

        if(foundProduct.isPresent()){
            return ResponseEntity.ok().body(foundProduct.get());
        }else {
            return ResponseEntity.ok().body(null);
        }
    }
}

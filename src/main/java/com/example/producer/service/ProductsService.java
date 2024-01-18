package com.example.producer.service;

import com.example.producer.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductsService {

    @Value("${products.file.name}")
    private String productFileName;

    @Value("${products.count}")
    private Integer count;

    @Value("classpath:${products.file.name}")
    private File productsFile;

    private List<Product> products = new ArrayList<>();


    @PostConstruct
    public void loadProducts(){
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> tempProducts;
        try{
            System.out.println(this.productFileName);
            System.out.println(this.count);
            tempProducts = objectMapper.readValue(productsFile, new TypeReference<List<Product>>(){} );
        }catch (IOException e) {
            log.error("Producer was unable to read products from file");
            throw new RuntimeException("Producer was unable to read products from file", e);
        }
        Collections.shuffle(tempProducts);
        this.products = tempProducts.stream().limit(this.count).collect(Collectors.toList());
    }

    public List<Product> getAllProducts() {
        return products;
    }
}

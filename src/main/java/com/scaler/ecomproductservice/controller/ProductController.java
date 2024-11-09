package com.scaler.ecomproductservice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.scaler.ecomproductservice.dto.ProductListResponseDTO;
import com.scaler.ecomproductservice.dto.ProductRequestDTO;
import com.scaler.ecomproductservice.dto.ProductResponseDTO;
import com.scaler.ecomproductservice.service.ProductService;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @GetMapping("/products")
    @Qualifier("fakeStoreProductService")
    public ResponseEntity getAllProducts() {
        /*
            ProductResponseDTO p1 = new ProductResponseDTO();
            p1.setId(1);
            p1.setTitle("Iphone 15 pro");
            p1.setPrice(150000);
            p1.setImage("www.google.com/images/iphone");
            p1.setDescription("Overrated phone");
            p1.setCategory("Mobile Phones");

            ProductResponseDTO p2 = new ProductResponseDTO();
            p2.setId(2);
            p2.setTitle("Macbook pro");
            p2.setPrice(250000);
            p2.setImage("www.google.com/images/macbook");
            p2.setDescription("Overrated laptop");
            p2.setCategory("Laptop");

            List<ProductResponseDTO> products = Arrays.asList(p1, p2);
            return ResponseEntity.ok(products);
        */
        ProductListResponseDTO response =  productService.getAllProducts();
        return ResponseEntity.ok(response);
    }
    
}

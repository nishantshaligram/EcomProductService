package com.scaler.ecomproductservice.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.scaler.ecomproductservice.dto.ProductListResponseDTO;
import com.scaler.ecomproductservice.dto.ProductRequestDTO;
import com.scaler.ecomproductservice.dto.ProductResponseDTO;
import com.scaler.ecomproductservice.exception.ProductNotFoundException;
import com.scaler.ecomproductservice.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class ProductController {

    private final ProductService productService; // immutable

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity getAllProducts() {
        List<ProductResponseDTO> response =  productService.getAllProducts();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductById(@PathVariable Integer id) throws ProductNotFoundException {
        ProductResponseDTO response =  productService.getProductById(1);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
       ProductResponseDTO response = productService.createProduct(productRequestDTO);
       return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") Integer id) {
        boolean response = productService.deleteProduct(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity updateProduct(@PathVariable int id, @RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO response = productService.updateProduct(id, productRequestDTO);
        return ResponseEntity.ok(response);
    }
}

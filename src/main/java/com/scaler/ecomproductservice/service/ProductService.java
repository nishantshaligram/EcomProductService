package com.scaler.ecomproductservice.service;

import java.util.List;

import com.scaler.ecomproductservice.dto.ProductListResponseDTO;
import com.scaler.ecomproductservice.dto.ProductRequestDTO;
import com.scaler.ecomproductservice.dto.ProductResponseDTO;
import com.scaler.ecomproductservice.exception.ProductNotFoundException;
import com.scaler.ecomproductservice.model.Product;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(int id) throws ProductNotFoundException;
    ProductResponseDTO createProduct(ProductRequestDTO product);
    boolean deleteProduct(int id);
    ProductResponseDTO updateProduct(int id, ProductRequestDTO updatedProduct);
}

package com.scaler.ecomproductservice.service;

import java.util.List;

import com.scaler.ecomproductservice.dto.ProductListResponseDTO;
import com.scaler.ecomproductservice.model.Product;

public interface ProductService {
    ProductListResponseDTO getAllProducts();
    Product getProductById(int id);
    Product createProduct(Product product);
    Product deleteProduct(int id);
    Product updateProduct(int id, Product updatedProduct);
}

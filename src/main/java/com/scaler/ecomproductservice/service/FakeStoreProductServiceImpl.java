package com.scaler.ecomproductservice.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.scaler.ecomproductservice.dto.ProductListResponseDTO;
import com.scaler.ecomproductservice.dto.ProductResponseDTO;
import com.scaler.ecomproductservice.model.Product;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplateBuilder  restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        String getAllProductsURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<List<ProductResponseDTO>> productResponse = restTemplate.exchange(getAllProductsURL, HttpMethod.GET, null,new ParameterizedTypeReference<List<ProductResponseDTO>>() {});
        return productResponse.getBody();
        // return null;
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        String getAllProductsURL = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse = restTemplate.getForEntity(getAllProductsURL, ProductResponseDTO.class);
        return productResponse.getBody();
    }

    @Override
    public Product createProduct(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createProduct'");
    }

    @Override
    public Product deleteProduct(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

}

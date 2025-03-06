package com.scaler.ecomproductservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import com.scaler.ecomproductservice.client.FakeStoreAPIClient;
import com.scaler.ecomproductservice.dto.FakeStoreProductRequestDTO;
import com.scaler.ecomproductservice.dto.FakeStoreProductResponseDTO;
import com.scaler.ecomproductservice.dto.ProductRequestDTO;
import com.scaler.ecomproductservice.dto.ProductResponseDTO;
import com.scaler.ecomproductservice.exception.ProductNotFoundException;
import static com.scaler.ecomproductservice.mapper.ProductMapper.productRequestToFakeStoreProductRequest;
import static com.scaler.ecomproductservice.mapper.ProductMapper.fakeStoreProductResponseToProductResponse;
import static com.scaler.ecomproductservice.util.ProductUtils.isNull;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplateBuilder  restTemplateBuilder;
    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreAPIClient fakeStoreAPIClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOs = fakeStoreAPIClient.getAllProducts();
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();
        for( FakeStoreProductResponseDTO fakeStoreProductResponseDTO : fakeStoreProductResponseDTOs ){
            productResponseDTOs.add(fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO));
        }
        return productResponseDTOs;
    }

    @Override
    public ProductResponseDTO getProductById(int id) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductDTO = fakeStoreAPIClient.getProductById(id);
        if( isNull(fakeStoreProductDTO) ){
            throw new ProductNotFoundException("Product not found with id : " + id);
        }
        return  fakeStoreProductResponseToProductResponse(fakeStoreProductDTO); 
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO =  productRequestToFakeStoreProductRequest(productRequestDTO);
        FakeStoreProductResponseDTO fakeStoreProductDTO = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDTO);
        return  fakeStoreProductResponseToProductResponse(fakeStoreProductDTO);
    }

    @Override
    public boolean deleteProduct(int id) {
       fakeStoreAPIClient.deleteProduct(id);
       return true;
    }

    @Override
    public ProductResponseDTO updateProduct(int id, ProductRequestDTO productRequestDTO) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO =  productRequestToFakeStoreProductRequest(productRequestDTO);
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.updateProduct(id, fakeStoreProductRequestDTO);
        return fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }

}

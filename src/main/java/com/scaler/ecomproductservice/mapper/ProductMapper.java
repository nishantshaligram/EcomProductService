package com.scaler.ecomproductservice.mapper;

import com.scaler.ecomproductservice.dto.FakeStoreProductRequestDTO;
import com.scaler.ecomproductservice.dto.FakeStoreProductResponseDTO;
import com.scaler.ecomproductservice.dto.ProductRequestDTO;
import com.scaler.ecomproductservice.dto.ProductResponseDTO;

public class ProductMapper {

    public static FakeStoreProductRequestDTO productRequestToFakeStoreProductRequest( ProductRequestDTO productRequestDTO ){
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = new FakeStoreProductRequestDTO();
        fakeStoreProductRequestDTO.setTitle(productRequestDTO.getTitle());
        fakeStoreProductRequestDTO.setDescription(productRequestDTO.getDescription());
        fakeStoreProductRequestDTO.setPrice(productRequestDTO.getPrice());
        fakeStoreProductRequestDTO.setCategory(productRequestDTO.getCategory());
        fakeStoreProductRequestDTO.setImage(productRequestDTO.getImage());
        return fakeStoreProductRequestDTO;
    }

    public static ProductResponseDTO fakeStoreProductResponseToProductResponse( FakeStoreProductResponseDTO fakeStoreProductResponseDTO ){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setTitle(fakeStoreProductResponseDTO.getTitle());
        productResponseDTO.setDescription(fakeStoreProductResponseDTO.getDescription());
        productResponseDTO.setPrice(fakeStoreProductResponseDTO.getPrice());
        productResponseDTO.setCategory(fakeStoreProductResponseDTO.getCategory());
        productResponseDTO.setImage(fakeStoreProductResponseDTO.getImage());
        return productResponseDTO;
    }
}

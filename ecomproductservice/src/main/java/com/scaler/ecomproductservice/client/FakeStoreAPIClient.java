package com.scaler.ecomproductservice.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.scaler.ecomproductservice.dto.FakeStoreProductRequestDTO;
import com.scaler.ecomproductservice.dto.FakeStoreProductResponseDTO;
import com.scaler.ecomproductservice.dto.ProductRequestDTO;
import com.scaler.ecomproductservice.dto.ProductResponseDTO;

/**
 * Wrapper on FakeStoreProduct APIs
 */
@Component
public class FakeStoreAPIClient {

    private RestTemplateBuilder restTemplateBuilder;
    private String fakeStoreAPIURL;
    @Value("${fakestore.api.path.product}")
    private String fakeStoreAPIPathProduct;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder,@Value("${fakestore.api.url}") String fakeStoreAPIURL) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIURL = fakeStoreAPIURL;
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
        String createProductURL = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> response = restTemplate.postForEntity( createProductURL, fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return response.getBody();
    }
    
    public FakeStoreProductResponseDTO getProductById( int id ) {
        String getProductByUrlId = fakeStoreAPIURL + fakeStoreAPIPathProduct + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> response = restTemplate.getForEntity(getProductByUrlId, FakeStoreProductResponseDTO.class);
        return response.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String getAllProductsURL = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<List<FakeStoreProductResponseDTO>> response = restTemplate.exchange(getAllProductsURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<FakeStoreProductResponseDTO>>() {});
        return response.getBody();
    }
    
    public void deleteProduct(int id){
        String deleteProductURL = fakeStoreAPIURL + fakeStoreAPIPathProduct + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteProductURL);
    }

    public FakeStoreProductResponseDTO updateProduct(int id, FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
        String updateProductURL = fakeStoreAPIURL + fakeStoreAPIPathProduct + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        HttpEntity<FakeStoreProductRequestDTO> fakeStoreProductEntity = new HttpEntity<FakeStoreProductRequestDTO>(fakeStoreProductRequestDTO);
        ResponseEntity<FakeStoreProductResponseDTO> response = restTemplate.exchange( updateProductURL, HttpMethod.PUT, fakeStoreProductEntity, new ParameterizedTypeReference<FakeStoreProductResponseDTO>() {});
        return response.getBody();
    }
}

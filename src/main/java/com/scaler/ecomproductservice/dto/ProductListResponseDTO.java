package com.scaler.ecomproductservice.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductListResponseDTO {
    private List<ProductResponseDTO> products;
}

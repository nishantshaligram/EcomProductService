package com.scaler.ecomproductservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private String title;
    private double price;
    private String Category;
    private String description;
    private String image;
}

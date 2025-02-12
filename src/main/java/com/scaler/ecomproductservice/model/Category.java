package com.scaler.ecomproductservice.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity 
public class Category extends BaseModel {
    private String categoryName;
}

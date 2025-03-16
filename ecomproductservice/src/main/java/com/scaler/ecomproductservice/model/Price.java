package com.scaler.ecomproductservice.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Price extends BaseModel{
    private String currency;
    private double amount;
    private double discount;
}

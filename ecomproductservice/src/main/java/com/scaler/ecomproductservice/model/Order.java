package com.scaler.ecomproductservice.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode( callSuper = true )
@Entity(name = "ECOM_ORDER")
public class Order extends BaseModel{
    @ManyToMany
    private List<Product> products;
}

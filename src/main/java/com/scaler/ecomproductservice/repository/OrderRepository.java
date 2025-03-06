package com.scaler.ecomproductservice.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.scaler.ecomproductservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, UUID> {

}

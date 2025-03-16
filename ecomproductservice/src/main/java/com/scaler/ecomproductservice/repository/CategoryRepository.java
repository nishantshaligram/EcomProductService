package com.scaler.ecomproductservice.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.scaler.ecomproductservice.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID>{

}

package com.group5.ecommerce.dao;

import com.group5.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// Product = Entity
// Long = Primary Key
public interface ProductRepository extends JpaRepository<Product, Long> {
}

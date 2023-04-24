package group5.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import group5.ecommerce.entity.Product;

// Product = Entity
// Long = Primary Key
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}

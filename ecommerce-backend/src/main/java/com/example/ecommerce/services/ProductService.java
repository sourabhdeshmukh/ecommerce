package com.example.ecommerce.services;

import com.example.ecommerce.wrappers.product.ProductWrapper;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    public void create(ProductWrapper productWrapper, Category category) {
        Product product = getProductFromDto(productWrapper, category);
        productRepo.save(product);
    }
    public static Product getProductFromDto(ProductWrapper productWrapper, Category category) {
        Product product = new Product();
        product.setCategory(category);
        product.setDescription(productWrapper.getDescription());
        product.setImgURL(productWrapper.getImgURL());
        product.setPrice(productWrapper.getPrice());
        product.setProductName(productWrapper.getName());
        return product;
    }
}

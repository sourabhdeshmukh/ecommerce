package com.example.ecommerce.controller;

import com.example.ecommerce.wrappers.product.ProductWrapper;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.services.CategoryService;
import com.example.ecommerce.services.ProductService;
import com.example.ecommerce.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ResponseUtil> create(@RequestBody ProductWrapper product){
        try {
            Optional<Category> category = categoryService.getCategory(product.getCategoryId());
            if (!category.isPresent())
                return new ResponseEntity<>(new ResponseUtil(false, "Invalid category. Category doesn't exist"), HttpStatus.CONFLICT);

            productService.create(product, category.get());
            return new ResponseEntity<>(new ResponseUtil(true, "Product is created"), HttpStatus.CREATED);
        }
        catch (Exception e){
            System.out.println(" Message "+ e.getMessage() +" Stack trace : "+ Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(new ResponseUtil(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.example.ecommerce.services;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepo;

    public void create(Category category){
        categoryRepo.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }

    public Category getCategory(String categoryName) {
        return categoryRepo.findByCategoryName(categoryName);
    }

    public Optional<Category> getCategory(Integer categoryId) {
        return categoryRepo.findById(categoryId);
    }

    public void update(Integer entityId, Category newCategory) {
        Category category = categoryRepo.findById(entityId).get();
        category.setCategoryName(newCategory.getCategoryName());
        category.setDescription(newCategory.getDescription());
        category.setImgURL(newCategory.getImgURL());
        categoryRepo.save(category);
    }
}

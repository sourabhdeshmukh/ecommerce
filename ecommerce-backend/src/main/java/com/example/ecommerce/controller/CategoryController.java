package com.example.ecommerce.controller;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.services.CategoryService;
import com.example.ecommerce.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/entity")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/create")
    public ResponseEntity<ResponseUtil> createEntity(@Valid @RequestBody Category category){
        try {
            //duplicate check
            if(Objects.nonNull(categoryService.getCategory(category.getCategoryName())))
                return new ResponseEntity<ResponseUtil>(new ResponseUtil(false, "Category already exist"), HttpStatus.CONFLICT);
            categoryService.create(category);
            return new ResponseEntity<>(new ResponseUtil(true, "Created a new category"), HttpStatus.CREATED);
        }
        catch (Exception e){
            System.out.println(" Message "+ e.getMessage() +" Stack trace : "+ e.getStackTrace());
            return new ResponseEntity<ResponseUtil>(new ResponseUtil(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/showAll")
    public ResponseEntity<List<Category>> showAllEntity(){
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories , HttpStatus.OK);
    }

    @PostMapping("edit/{categoryId}")
    public ResponseEntity<ResponseUtil> editEntity(@PathVariable("categoryId") Integer Id, @Valid @RequestBody Category category){
        //if entity exist update
        try {
            if(Objects.nonNull(categoryService.getCategory(Id))){
                categoryService.update(Id , category);
                return new ResponseEntity<>(new ResponseUtil(true, "Category is updated successfully"), HttpStatus.OK);
            }
            else
                return new ResponseEntity<>(new ResponseUtil(false, "Category doesn't exist in the system"), HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            System.out.println(" Message "+ e.getMessage() +" Stack trace : "+ e.getStackTrace());
            return new ResponseEntity<ResponseUtil>(new ResponseUtil(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

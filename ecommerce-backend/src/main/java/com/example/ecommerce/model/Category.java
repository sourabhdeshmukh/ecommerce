package com.example.ecommerce.model;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private @NotBlank String categoryName;

    private @NotBlank String description;

    private @NotBlank String imgURL;

    public Category(){

    }
    public Category(@NotBlank String categoryName, @NotBlank String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public Category(@NotBlank String categoryName, @NotBlank String description, @NotBlank String imageUrl) {
        this.categoryName = categoryName;
        this.description = description;
        this.imgURL = imageUrl;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User {category id=" + id + ", category name='" + categoryName + "', description='" + description + "'}";
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setImgURL(String imgURL){
        this.imgURL=imgURL;
    }

    public String getImgURL(){
        return imgURL;
    }




}

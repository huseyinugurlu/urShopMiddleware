package com.example.urshopmiddleware.controller.product;


import com.example.urshopmiddleware.model.Category;

public record UpdateProductRequest (
        int id,
        String name,
        float price,
        int stock,
        String description,
        Integer categoryId){
   
}

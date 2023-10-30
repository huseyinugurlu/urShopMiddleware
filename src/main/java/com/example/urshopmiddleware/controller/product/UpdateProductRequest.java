package com.example.urshopmiddleware.controller.product;


public record UpdateProductRequest(
        int id,
        String name,
        float price,
        int stock,
        String description,
        Integer categoryId) {

}

package com.example.urshopmiddleware.controller.product;


public record CreateProductRequest(String name, float price, int stock, String description, Integer categoryId) {
}

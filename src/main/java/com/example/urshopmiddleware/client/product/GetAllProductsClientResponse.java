package com.example.urshopmiddleware.client.product;

public record GetAllProductsClientResponse(
        int id,String name, float price, int stock, String description, Integer categoryId) {
}
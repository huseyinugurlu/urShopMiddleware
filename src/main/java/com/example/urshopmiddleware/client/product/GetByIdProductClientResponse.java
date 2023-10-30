package com.example.urshopmiddleware.client.product;


public record GetByIdProductClientResponse(
        String name, float price, int stock, String description, Integer categoryId) {
}

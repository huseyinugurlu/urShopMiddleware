package com.example.urshopmiddleware.client.product;


public record UpdateProductClientRequest(
        String name,
        float price,
        int stock,
        String description,
        Integer categoryId) {

}

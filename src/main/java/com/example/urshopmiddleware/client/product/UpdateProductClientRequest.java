package com.example.urshopmiddleware.client.product;


public record UpdateProductClientRequest(int id,
                                         String name,
                                         float price,
                                         int stock,
                                         String description,
                                         Integer clientCategoryId) {

}

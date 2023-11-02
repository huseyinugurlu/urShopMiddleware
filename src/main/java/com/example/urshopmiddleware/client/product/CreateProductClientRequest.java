package com.example.urshopmiddleware.client.product;


public record CreateProductClientRequest(String name, float price, int stock, String description,
                                         int categoryId) {

}

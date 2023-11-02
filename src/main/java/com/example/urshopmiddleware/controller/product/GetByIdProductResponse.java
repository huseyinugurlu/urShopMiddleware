package com.example.urshopmiddleware.controller.product;


import com.example.urshopmiddleware.model.Product;

public record GetByIdProductResponse(
        int id, String name, float price, int stock, String description, Integer categoryId) {
    public static GetByIdProductResponse fromProduct(Product product) {
        return new GetByIdProductResponse(
                product.getProductId(),
                product.getProductName(),
                product.getPrice(),
                product.getStock(),
                product.getDescription(),
                product.getCategoryId());
    }
}

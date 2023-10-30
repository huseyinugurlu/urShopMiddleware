package com.example.urshopmiddleware.controller.product;


import com.example.urshopmiddleware.model.Product;

import java.util.List;


public record GetAllProductsResponse(
        String name, float price, int stock, String description, Integer categoryId) {

    public static List<GetAllProductsResponse> fromProducts(List<Product> products) {
        return products.stream().map(GetAllProductsResponse::fromProduct).toList();
    }

    public static GetAllProductsResponse fromProduct(Product product) {
        return new GetAllProductsResponse(
                product.getProductName(),
                product.getPrice(),
                product.getStock(),
                product.getDescription(),
                product.getCategoryId()
        );
    }

}


package com.example.urshopmiddleware.client.category;


import java.util.Set;

public record GetByIdCategoryClientResponse(int id, String name, Set<Integer> productIds) {
}


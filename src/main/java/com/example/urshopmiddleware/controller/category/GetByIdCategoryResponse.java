package com.example.urshopmiddleware.controller.category;

import com.example.urshopmiddleware.model.Category;

import java.util.Set;

public record GetByIdCategoryResponse(int id,String name, Set<Integer> productIds) {
    public static GetByIdCategoryResponse fromCategory(Category category) {
        return new GetByIdCategoryResponse(
                category.getCategoryId(),
                category.getCategoryName(),
                category.getProductIds());
    }
}

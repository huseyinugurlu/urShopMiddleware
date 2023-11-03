package com.example.urshopmiddleware.controller.category;

import com.example.urshopmiddleware.model.Category;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record GetAllCategoryResponse(int id,String name, Set<Integer> productIds) {
    public static List<GetAllCategoryResponse> fromCategories(List<Category> categories) {
        return categories.stream().map(GetAllCategoryResponse::fromCategory).toList();
    }

    public static GetAllCategoryResponse fromCategory(Category category) {
        return new GetAllCategoryResponse(
                category.getCategoryId(),
                category.getCategoryName(),
                category.getProductIds());
    }
}

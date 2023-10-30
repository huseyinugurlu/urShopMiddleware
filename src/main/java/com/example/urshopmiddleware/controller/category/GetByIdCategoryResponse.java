package com.example.urshopmiddleware.controller.category;

import java.util.Set;

public record GetByIdCategoryResponse(String name, Set<Integer> productIds) {
}

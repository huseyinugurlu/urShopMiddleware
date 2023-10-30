package com.example.urshopmiddleware.controller.category;

import java.util.Set;

public record GetAllCategoryResponse(String name, Set<Integer> productIds) {
}

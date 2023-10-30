package com.example.urshopmiddleware.controller.category;

import java.util.Set;

public record CreateCategoryRequest(String name, Set<Integer> productIds) {

}
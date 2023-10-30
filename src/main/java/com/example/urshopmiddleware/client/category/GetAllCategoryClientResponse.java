package com.example.urshopmiddleware.client.category;

import java.util.Set;

public record GetAllCategoryClientResponse(Integer id, String name, Set<Integer> productIds) {
}

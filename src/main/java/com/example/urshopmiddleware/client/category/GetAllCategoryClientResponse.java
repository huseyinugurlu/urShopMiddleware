package com.example.urshopmiddleware.client.category;

import java.util.Set;

public record GetAllCategoryClientResponse(int id, String name, Set<Integer> productIds) {
}

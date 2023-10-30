package com.example.urshopmiddleware.client.category;


import java.util.Set;

public record CreateCategoryClientRequest(String name, Set<Integer> productIds) {

}

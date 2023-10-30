package com.example.urshopmiddleware.model;


import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class Category {
    private int categoryId;
    private String categoryName;
    private Set<Integer> productIds;

}

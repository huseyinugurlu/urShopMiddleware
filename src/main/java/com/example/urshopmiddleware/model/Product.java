package com.example.urshopmiddleware.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class Product {
    private int productId;
    private String productName;
    private float price;
    private int stock;
    private String description;
    private Integer categoryId;
    private Set<Integer> productFeatureValueMapIds;
    private Set<Integer> productCustomerOfferMapIds;

}

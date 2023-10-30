package com.example.urshopmiddleware.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class CustomerOffer {
    private int id;
    private float totalAmount;
    private Set<Integer> productCustomerOfferMapIds;

}

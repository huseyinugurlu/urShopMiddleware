package com.example.urshopmiddleware.client.customerOffer;


import java.util.Set;

public record GetByIdOfferClientResponse(int id, float totalAmount, Set<Integer> productCustomerOfferMapIds) {
}

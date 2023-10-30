package com.example.urshopmiddleware.client.customerOffer;


import java.util.Set;

public record GetByIdOfferClientResponse(float totalAmount, Set<Integer> productIds) {
}

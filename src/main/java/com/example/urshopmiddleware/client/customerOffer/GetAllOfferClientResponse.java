package com.example.urshopmiddleware.client.customerOffer;


import java.util.Set;

public record GetAllOfferClientResponse(float totalAmount, Set<Integer> clientProductCustomerOfferMapIds) {
}

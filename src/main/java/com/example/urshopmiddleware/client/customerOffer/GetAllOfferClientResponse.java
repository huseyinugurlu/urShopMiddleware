package com.example.urshopmiddleware.client.customerOffer;


import java.util.Set;

public record GetAllOfferClientResponse(int id, float totalAmount, Set<Integer> clientProductCustomerOfferMapIds) {
}

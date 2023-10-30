package com.example.urshopmiddleware.controller.customerOffer;


import com.example.urshopmiddleware.model.CustomerOffer;

import java.util.Set;

public record GetByIdOfferResponse(float totalAmount, Set<Integer> productIds) {
    public static GetByIdOfferResponse fromOffer(CustomerOffer customerOffer) {
        return new GetByIdOfferResponse(customerOffer.getTotalAmount(), customerOffer.getProductCustomerOfferMapIds());
    }
}

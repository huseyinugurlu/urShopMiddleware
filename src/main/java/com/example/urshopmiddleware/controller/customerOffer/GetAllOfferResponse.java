package com.example.urshopmiddleware.controller.customerOffer;


import com.example.urshopmiddleware.model.CustomerOffer;

import java.util.List;
import java.util.Set;

public record GetAllOfferResponse(int id,float totalAmount, Set<Integer> productIds) {
    public static List<GetAllOfferResponse> fromOffers(List<CustomerOffer> customerOffers) {
        return customerOffers.stream().map(GetAllOfferResponse::fromOffer).toList();
    }

    public static GetAllOfferResponse fromOffer(CustomerOffer customerOffer) {
        return new GetAllOfferResponse(customerOffer.getId(), customerOffer.getTotalAmount(), customerOffer.getProductCustomerOfferMapIds());
    }
}

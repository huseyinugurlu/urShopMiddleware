package com.example.urshopmiddleware.controller.customerOffer;


import com.example.urshopmiddleware.model.CustomerOffer;
import com.example.urshopmiddleware.model.Product;

import java.util.List;
import java.util.Set;

public record GetAllOfferResponse(float totalAmount, Set<Integer> productIds) {
    public static List<GetAllOfferResponse> fromOffers(List<CustomerOffer> customerOffers){
        return customerOffers.stream().map(GetAllOfferResponse::fromOffer).toList();
    }
    public static GetAllOfferResponse fromOffer(CustomerOffer customerOffer){
        return new GetAllOfferResponse(customerOffer.getTotalAmount(), customerOffer.getProductCustomerOfferMapIds());
    }
}

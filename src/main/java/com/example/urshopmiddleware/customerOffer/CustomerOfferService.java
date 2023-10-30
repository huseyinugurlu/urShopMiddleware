package com.example.urshopmiddleware.customerOffer;


import com.example.urshopmiddleware.model.CustomerOffer;

import java.util.List;

public interface CustomerOfferService {
    List<CustomerOffer> getAll();

    CustomerOffer getById(int offerId);

    void delete(int offerId);
}

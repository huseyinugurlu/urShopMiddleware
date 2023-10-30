package com.example.urshopmiddleware.model;

import lombok.Builder;

@Builder
public class ProductCustomerOfferMap {
    private int mapId;
    private Integer productId;
    private Integer customerOfferId;

}

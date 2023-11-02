package com.example.urshopmiddleware.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductCustomerOfferMap {
    private int mapId;
    private Integer productId;
    private Integer customerOfferId;

}

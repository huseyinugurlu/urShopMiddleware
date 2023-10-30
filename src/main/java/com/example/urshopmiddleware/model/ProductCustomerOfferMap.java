package com.example.urshopmiddleware.model;

import lombok.Builder;

import java.util.List;
import java.util.Set;

@Builder
public class ProductCustomerOfferMap {
    private int mapId;
    private Integer productId;
    private Integer customerOfferId;

}

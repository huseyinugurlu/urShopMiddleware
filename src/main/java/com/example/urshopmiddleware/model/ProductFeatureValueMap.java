package com.example.urshopmiddleware.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductFeatureValueMap {
    private int id;
    private Integer productId;
    private Integer featureValueId;
}

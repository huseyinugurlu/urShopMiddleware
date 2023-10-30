package com.example.urshopmiddleware.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;

@Builder
@Getter
public class Order {
    private int id;
    private float totalAmount;
    private LocalDate orderDate;
    private Integer customerId;
    private Set<Integer> orderItemIds;
}

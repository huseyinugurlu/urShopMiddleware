package com.example.urshopmiddleware.model;

import java.time.LocalDate;
import java.util.Set;


public class Order {
    private int id;
    private float totalAmount;
    private LocalDate orderDate;
    private Integer customerId;
    private Set<Integer> orderItemIds;
}

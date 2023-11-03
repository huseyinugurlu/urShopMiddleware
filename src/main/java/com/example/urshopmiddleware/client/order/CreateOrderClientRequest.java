package com.example.urshopmiddleware.client.order;


import java.util.Date;
import java.util.Set;

public record CreateOrderClientRequest(
        float totalAmount, Date orderDate, Integer customerId, Set<Integer> orderItemIds) {
}

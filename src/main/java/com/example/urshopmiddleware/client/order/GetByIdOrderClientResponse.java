package com.example.urshopmiddleware.client.order;


import java.time.LocalDate;
import java.util.Set;

public record GetByIdOrderClientResponse(
        int id, float totalAmount, LocalDate orderDate, Integer customerId, Set<Integer> orderItemIds) {

}

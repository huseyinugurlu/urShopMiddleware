package com.example.urshopmiddleware.client.order;


import com.example.urshopmiddleware.client.clientmodel.ClientOrder;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record GetAllOrderClientResponse(float totalAmount, LocalDate orderDate, Integer clientCustomerId,
                                        Set<Integer> clientOrderItemIds) {
}

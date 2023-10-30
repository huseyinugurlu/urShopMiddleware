package com.example.urshopmiddleware.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Builder
@Getter
@Setter
public class PaymentCard {
    private int id;
    private long cardNumber;
    private String cardHolderName;
    private LocalDate expirationDate;
    private int cvv;
    private Integer customerId;

}

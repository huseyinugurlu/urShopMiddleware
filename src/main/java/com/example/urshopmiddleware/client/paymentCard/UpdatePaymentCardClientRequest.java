package com.example.urshopmiddleware.client.paymentCard;


import java.time.LocalDate;

public record UpdatePaymentCardClientRequest(
        long cardNumber,
        String cardHolderName,
        LocalDate expirationDate,
        int cvv
) {
}
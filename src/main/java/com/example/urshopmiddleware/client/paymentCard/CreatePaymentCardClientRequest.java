package com.example.urshopmiddleware.client.paymentCard;


import java.time.LocalDate;

public record CreatePaymentCardClientRequest(
        long cardNumber,
        String cardHolderName,
        LocalDate expirationDate,
        int cvv,
        Integer customerId) {
}

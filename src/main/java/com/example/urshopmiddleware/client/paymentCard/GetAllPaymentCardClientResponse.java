package com.example.urshopmiddleware.client.paymentCard;


import java.time.LocalDate;

public record GetAllPaymentCardClientResponse(
        int id, long cardNumber, String cardHolderName, LocalDate expirationDate, int cvv, Integer customerId) {
}

package com.example.urshopmiddleware.client.cashier;

public record GetByIdCashierClientResponse(
        int id, String userName, String email, String creationDate, long cashierNumber) {
}

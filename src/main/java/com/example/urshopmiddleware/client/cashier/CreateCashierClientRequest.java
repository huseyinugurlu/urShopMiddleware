package com.example.urshopmiddleware.client.cashier;

import java.time.LocalDateTime;

public record CreateCashierClientRequest(
    String userName,
    String email,
    String password,
    LocalDateTime creationDate,
    long cashierNumber) {}

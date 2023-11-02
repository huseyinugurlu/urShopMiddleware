package com.example.urshopmiddleware.controller;

import com.example.urshopmiddleware.exception.UrShopFallbackClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

public class BaseController {


    public ResponseEntity<?> success(Object data) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("success", true);
        hashMap.put("error", null);
        hashMap.put("data", data);
        return ResponseEntity.ok(hashMap);

    }

    private ResponseEntity<?> error(String errorMessage) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("success", false);
        hashMap.put("error", errorMessage);
        hashMap.put("data", null);
        return ResponseEntity.ok(hashMap);
    }

    @ExceptionHandler(UrShopFallbackClient.class)
    public ResponseEntity<?> handleBusinessException(UrShopFallbackClient businessException) {
        return error(businessException.getMessage());
    }


}
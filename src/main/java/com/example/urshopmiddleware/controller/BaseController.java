package com.example.urshopmiddleware.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

public class BaseController {


    public ResponseEntity<BaseResponse<?>> success(Object data) {
        BaseResponse<?> response = success2(data);
        return ResponseEntity.ok(response);
    }

    public <T>  BaseResponse<T> success2(T data) {
        return new BaseResponse<>(true, null, data);
    }

    private  ResponseEntity<?> error(String errorMessage) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("success", false);
        hashMap.put("error", errorMessage);
        hashMap.put("data", null);
        return ResponseEntity.ok(hashMap);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleBusinessException(RuntimeException businessException){
        return error(businessException.getMessage());
    }

    public record BaseResponse<T>(Boolean success,String error,T data){

    }
}
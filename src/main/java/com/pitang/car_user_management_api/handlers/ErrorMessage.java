package com.pitang.car_user_management_api.handlers;

import lombok.Data;

@Data
public class ErrorMessage {

    private int erroCode;
    private String message;

    public ErrorMessage(int erroCode, String message) {
        this.erroCode = erroCode;
        this.message = message;
    }
}

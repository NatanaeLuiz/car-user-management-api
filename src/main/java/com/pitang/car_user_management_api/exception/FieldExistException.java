package com.pitang.car_user_management_api.exception;

import com.pitang.car_user_management_api.handlers.ErrorMessage;

public class FieldExistException extends RuntimeException{

    private ErrorMessage errorMessage;
    public FieldExistException(ErrorMessage  errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}

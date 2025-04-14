package com.register.usermanagement.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {

    private final String message;

    public UserNotFoundException(String message) {
        this.message = message;
    }
}

package com.register.usermanagement.exception.handler;

import com.register.usermanagement.exception.UserNotFoundException;
import com.register.usermanagement.util.ResponseBuilder;
import com.register.usermanagement.util.SimpleErrorRespond;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserNotFoundExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<SimpleErrorRespond> UserNotFoundException(UserNotFoundException ex){
        return ResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}

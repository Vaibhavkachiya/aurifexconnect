package com.register.usermanagement.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

    public static<T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status,String message, T data){

        ResponseStructure<T> responseStructure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status)
                .body(responseStructure);
    }

    public static<T> ResponseEntity<SimpleErrorRespond> error(HttpStatus status, String message){

        SimpleErrorRespond error = SimpleErrorRespond.builder()
                .type(status.name())
                .message(message)
                .status(status.value())
                .build();

        return ResponseEntity.status(status)
                .body(error);
    }
}

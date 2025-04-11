package com.register.usermanagement.util;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ResponseStructure<T> {

    private int status;

    private String message;

    private T data;
}

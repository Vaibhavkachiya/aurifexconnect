package com.register.usermanagement.exception.handler;

import com.register.usermanagement.util.FieldErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.List;

@RestControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        List<FieldErrorResponse.CustomFieldError> errors = ex.getAllErrors().stream()
                .map(error -> (FieldError)error)
                .map(this::createFieldError)
                .toList();
        FieldErrorResponse respose = createFieldErrorResponse(status, errors);
        return ResponseEntity.status(status).body(respose);
    }

    private static FieldErrorResponse createFieldErrorResponse(HttpStatusCode statusCode, List<FieldErrorResponse.CustomFieldError> errors) {
        return FieldErrorResponse.builder()
                .type(statusCode.toString())
                .status(statusCode.value())
                .message("Invalid Input")
                .errors(errors)
                .build();
    }


    private FieldErrorResponse.CustomFieldError createFieldError (FieldError filedError) {
        return FieldErrorResponse.createFieldError(
                filedError.getDefaultMessage(),
                filedError.getRejectedValue(),
                filedError.getField());

    }
}
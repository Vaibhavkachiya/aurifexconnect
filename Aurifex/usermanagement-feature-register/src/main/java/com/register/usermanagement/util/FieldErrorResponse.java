package com.register.usermanagement.util;

import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import java.util.List;

@Getter
@SuperBuilder
public class FieldErrorResponse extends SimpleErrorRespond{

    private List<CustomFieldError> errors;

    public static CustomFieldError createFieldError(String message, Object rejectValue,String field){
    CustomFieldError customFieldError =   new CustomFieldError();
    customFieldError.message=message;
    customFieldError.rejectValue=rejectValue;
    customFieldError.field=field;
    return customFieldError;
    }

    @Getter
    public static class CustomFieldError{
        private String message;
        private Object rejectValue;
        private String field;

    }

}

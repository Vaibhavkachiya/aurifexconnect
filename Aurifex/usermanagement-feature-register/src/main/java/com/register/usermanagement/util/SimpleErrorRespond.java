package com.register.usermanagement.util;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class SimpleErrorRespond {

    private String type;
    private int status;
    private String message;
}

package com.register.usermanagement.dto.request.user;

import com.register.usermanagement.entity.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    @NotBlank(message = "Username cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_]{4,20}$", message = "Username must be 4-20 characters long and contain only letters, numbers, or underscores")
    private String username;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$",
            message = "Password must contain at least one digit, one uppercase letter, one special character, and no whitespaces"
    )
    private String password;


    private Role role;
}


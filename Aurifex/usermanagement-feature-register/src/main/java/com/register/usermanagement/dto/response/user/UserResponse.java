package com.register.usermanagement.dto.response.user;

import com.register.usermanagement.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private Long id;

    private String username;

    private String email;

    private String password;

    private Role role;
}

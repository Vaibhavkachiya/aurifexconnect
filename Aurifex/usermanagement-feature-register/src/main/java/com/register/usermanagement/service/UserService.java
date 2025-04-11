package com.register.usermanagement.service;

import com.register.usermanagement.dto.request.user.UserRequest;
import com.register.usermanagement.dto.response.user.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest userRequest) ;

    UserResponse updateUserById(Long id, UserRequest userRequest);

    UserResponse deleteUserById(Long id);

    UserResponse findUserById(Long userId);

    List<UserResponse> getAllUsers();

    UserResponse login(String username, String password);
}

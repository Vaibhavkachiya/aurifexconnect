package com.register.usermanagement.controller;

import com.register.usermanagement.dto.request.user.LoginRequest;
import com.register.usermanagement.dto.request.user.UserRequest;
import com.register.usermanagement.dto.response.user.UserResponse;
import com.register.usermanagement.service.UserService;
import com.register.usermanagement.util.ResponseBuilder;
import com.register.usermanagement.util.ResponseStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name= "UserAPI" , description = "Create, Get, Update, Login, ......")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create User API
    @PostMapping
    @Operation(summary = "Create User")
    public ResponseEntity<ResponseStructure<UserResponse>> createUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.createUser(userRequest);
        return ResponseBuilder.success(HttpStatus.CREATED, "User Created Successfully", userResponse);
    }

    // Update User API
    @PutMapping("/{id}")
    @Operation(summary = "Update User")
    public ResponseEntity<ResponseStructure<UserResponse>> updateUserById(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.updateUserById(id, userRequest);
        return ResponseBuilder.success(HttpStatus.OK, "User Updated Successfully", userResponse);
    }

    // Get User by ID API
    @GetMapping("/{id}")
    @Operation(summary = "Find User")
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable Long id) {
        UserResponse userResponse = userService.findUserById(id);
        return ResponseBuilder.success(HttpStatus.OK, "User Found Successfully", userResponse);
    }

    // Get All Users API
    @GetMapping
    @Operation(summary = "Get all Journal entries of a User")
    public ResponseEntity<ResponseStructure<List<UserResponse>>> getAllUsers() {
        List<UserResponse> userResponse = userService.getAllUsers();
        return ResponseBuilder.success(HttpStatus.OK, "All Users Found Successfully", userResponse);
    }

    // Delete User API
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete User")
    public ResponseEntity<ResponseStructure<UserResponse>> deleteUser(@PathVariable Long id) {
        UserResponse userResponse = userService.deleteUserById(id);
        return ResponseBuilder.success(HttpStatus.OK, "User Deleted Successfully", userResponse);
    }

    // Login API
    @PostMapping("/login")
    @Operation(summary = "Login User")
    public ResponseEntity<ResponseStructure<UserResponse>> login(@RequestBody LoginRequest loginRequest) {
        UserResponse userResponse = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
        return ResponseBuilder.success(HttpStatus.OK, "Logged-In Successfully", userResponse);
    }
}
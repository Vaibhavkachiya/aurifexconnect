package com.register.usermanagement.service.impl;

import com.register.usermanagement.dto.request.user.UserRequest;
import com.register.usermanagement.dto.response.user.UserResponse;
import com.register.usermanagement.entity.User;
import com.register.usermanagement.exception.UserNotFoundException;
import com.register.usermanagement.mapper.User.UserMapper;
import com.register.usermanagement.repository.UserRepository;
import com.register.usermanagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        // Check for duplicate email only
        if (userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
            throw new RuntimeException("Email '" + userRequest.getEmail() + "' is already registered");
        }
        else{
            User user = userMapper.mapToUserEntity(userRequest);
            userRepository.save(user);
            return userMapper.mapToUserResponse(user);
        }
    }

    @Override
    public UserResponse updateUserById(Long id, UserRequest userRequest) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));

        userMapper.mapToNewUser(userRequest,existingUser);
        return userMapper.mapToUserResponse(userRepository.save(existingUser));
    }

    @Override
    public UserResponse deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
        userRepository.deleteById(id);
        return userMapper.mapToUserResponse(user);
    }

    @Override
    public UserResponse findUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User Id " + userId + " not found"));
        return userMapper.mapToUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> user = userRepository.findAll();
        return userMapper.mapToUserList(user);
    }

    @Override
    public UserResponse login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        return userMapper.mapToUserResponse(user);
    }
}

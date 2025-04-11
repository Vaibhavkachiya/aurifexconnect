package com.register.usermanagement.mapper.User;

import com.register.usermanagement.dto.request.user.UserRequest;
import com.register.usermanagement.dto.response.user.UserResponse;
import com.register.usermanagement.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface UserMapper {

    User mapToUserEntity(UserRequest userRequest);

    UserResponse mapToUserResponse(User user);

    List<UserResponse> mapToUserList(List<User> user);

    void mapToNewUser(UserRequest userRequest, @MappingTarget User user);


}

package io.young.dev.userservice.service;

import io.young.dev.userservice.domain.UserEntity;
import io.young.dev.userservice.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();
}

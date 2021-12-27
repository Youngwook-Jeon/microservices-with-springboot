package io.young.dev.userservice.service;

import io.young.dev.userservice.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
}

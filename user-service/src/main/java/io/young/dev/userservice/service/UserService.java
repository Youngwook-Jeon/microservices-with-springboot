package io.young.dev.userservice.service;

import io.young.dev.userservice.domain.UserEntity;
import io.young.dev.userservice.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();

    UserDto getUserDetailsByEmail(String username);
}

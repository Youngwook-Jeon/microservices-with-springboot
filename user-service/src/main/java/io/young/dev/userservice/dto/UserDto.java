package io.young.dev.userservice.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class UserDto {

    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Instant createdAt;
    private String encryptedPwd;
}

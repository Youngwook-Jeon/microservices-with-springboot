package io.young.dev.userservice.dto;

import io.young.dev.userservice.vo.ResponseOrder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class UserDto {

    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Instant createdAt;
    private String encryptedPwd;
    private List<ResponseOrder> orders;
}

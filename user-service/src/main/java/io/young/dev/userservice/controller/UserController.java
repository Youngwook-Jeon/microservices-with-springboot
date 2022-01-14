package io.young.dev.userservice.controller;

import io.young.dev.userservice.dto.UserDto;
import io.young.dev.userservice.service.UserService;
import io.young.dev.userservice.vo.Greeting;
import io.young.dev.userservice.vo.RequestUser;
import io.young.dev.userservice.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final Environment env;
    private final UserService userService;

    @Autowired
    private Greeting greeting;

    @GetMapping("/health_check")
    public String status() {
        return "It is working in user service!";
    }

    @GetMapping("/welcome")
    public String welcome() {
//        return env.getProperty("greeting.message"); // 방법 1
        return greeting.getMessage(); // 방법 2
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser requestUser) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                        .setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = mapper.map(requestUser, UserDto.class);

        userService.createUser(userDto);

        ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }
}

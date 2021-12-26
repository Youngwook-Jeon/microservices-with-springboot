package io.young.dev.userservice.controller;

import io.young.dev.userservice.vo.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final Environment env;

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
}

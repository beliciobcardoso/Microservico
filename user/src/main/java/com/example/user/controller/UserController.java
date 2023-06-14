package com.example.user.controller;

import com.example.user.model.User;
import com.example.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = "/user")
    public User getUser() {
        log.info("Porta do servidor: " + port);
        return User.builder()
                .id(1L)
                .name("John Doe")
                .email("john@email.com")
                .port(port)
                .build();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/name")
    public String getUserName() {
        return userService.getUserName();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user/detail/{id}")
    public Map<String, Object> detail(@PathVariable("id") Long idUser) {
        String message = "Hello from user-service";

        Map<String, Object> response = new HashMap<>();
        response.put("id_user", idUser);
//        response.put("custom_header_value", header);
        response.put("message", message);


        return response;
    }
}

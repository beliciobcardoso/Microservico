package com.example.product.controller;


import com.example.product.model.DTO.UserDTO;
import com.example.product.service.UserEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/productuser")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserEndpoint userEndpoint;

    @GetMapping
    public UserDTO getUserDTO() {
        log.info("Product-service consumindo o User-service na porta: " + userEndpoint.getUserDTO().getPort());
        return userEndpoint.getUserDTO();
    }
}

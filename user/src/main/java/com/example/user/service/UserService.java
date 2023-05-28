package com.example.user.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserName() {
        return "John Doe";
    }

    public String getUserEmail() {
        return "john@gmail.com";
    }
}

package com.in28minutes.learn_spring_framework.app04.authenticationService;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        boolean isValidUsername = Objects.equals(username, "john");
        boolean isValidPassword = Objects.equals(password, "1234");
        return isValidUsername && isValidPassword;
    }
}

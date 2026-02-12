package com.uniDelivery.api.user.adabter.input.rest.controller;

import com.uniDelivery.api.user.adabter.input.rest.dto.AuthResponse;
import com.uniDelivery.api.user.adabter.input.rest.dto.CreateUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @PostMapping("/register")
    private ResponseEntity<AuthResponse> registerUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(new AuthResponse("",""));
    }
}

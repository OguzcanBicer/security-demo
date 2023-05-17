package com.oguzcan.securitydemo.controller;


import com.oguzcan.securitydemo.dto.request.UserRegisterRequestDTO;
import com.oguzcan.securitydemo.dto.response.AuthenticationResponseDTO;
import com.oguzcan.securitydemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(UserRegisterRequestDTO userRegisterRequestDTO) {
        return ResponseEntity.ok(userService.register(userRegisterRequestDTO));
    }
}

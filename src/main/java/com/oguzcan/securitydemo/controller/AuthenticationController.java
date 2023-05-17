package com.oguzcan.securitydemo.controller;

import com.oguzcan.securitydemo.dto.request.AuthenticationRequestDTO;
import com.oguzcan.securitydemo.dto.request.UserRegisterRequestDTO;
import com.oguzcan.securitydemo.dto.response.AuthenticationResponse;
import com.oguzcan.securitydemo.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody UserRegisterRequestDTO request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequestDTO request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
    service.refreshToken(request, response);
  }


}

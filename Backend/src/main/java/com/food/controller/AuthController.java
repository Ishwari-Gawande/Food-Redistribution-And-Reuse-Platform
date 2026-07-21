package com.food.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.DTO.ForgetPasswordDTO;
import com.food.DTO.LoginDTO;
import com.food.DTO.LoginResponseDTO;
import com.food.DTO.RegisterDTO;
import com.food.DTO.ResetPasswordDTO;
import com.food.service.AuthServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")public class AuthController {

	private final AuthServiceImpl authService;

	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterDTO request) {
		return ResponseEntity.ok(authService.register(request));
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginDTO request) {

	    return ResponseEntity.ok(authService.logIn(request));
	}

	@PostMapping("/forgot-password")
	public ResponseEntity<?> forgotPassword(@Valid @RequestBody ForgetPasswordDTO request) {
		return ResponseEntity.ok(authService.forgotPassword(request));
	}

	@PostMapping("/reset-password")
	public ResponseEntity<?> resetPassword(@Valid @RequestBody ResetPasswordDTO request) {
		return ResponseEntity.ok(authService.resetPassword(request));
	}
}

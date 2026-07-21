package com.food.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.DTO.NotificationDTO;
import com.food.service.NotificationServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/notification")

public class NotificationController {
@Autowired
	private NotificationServiceImpl notificationService;

	@PostMapping
	public ResponseEntity<?> sendNotification(@Valid @RequestBody NotificationDTO request) {

		return ResponseEntity.ok(notificationService.sendNotification(request));
	}

	@GetMapping
	public ResponseEntity<?> getMyNotifications() {

		return ResponseEntity.ok(notificationService.getMyNotifications());
	}

	@PutMapping("/{id}/read")
	public ResponseEntity<?> markAsRead(@PathVariable Long id) {

		return ResponseEntity.ok(notificationService.markAsRead(id));
	}
}

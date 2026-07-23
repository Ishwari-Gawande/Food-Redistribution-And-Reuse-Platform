package com.food.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.service.DashboardService;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

	private final DashboardService dashboardService;

	// Admin dashboard
	@GetMapping("/admin")
	public ResponseEntity<?> getAdminDashboard() {
		System.out.println("Admin Dashboard API is Called!");
		return ResponseEntity.ok(dashboardService.getAdminDashboard());
	}

	// Donor Dashboard
	@GetMapping("/donor")
	public ResponseEntity<?> getDonorDashboard(
			@Positive(message = "Id must be greater than 0") @PathVariable Long userId) {
		System.out.println("Donor Dashboard API is Called!");
		return ResponseEntity.ok(dashboardService.getDonorDashboard(userId));
	}

}

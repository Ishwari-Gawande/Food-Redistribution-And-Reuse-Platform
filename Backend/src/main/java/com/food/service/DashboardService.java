package com.food.service;

import com.food.DTO.AdminDashboardDTO;
import com.food.DTO.DonorDashboardDTO;

public interface DashboardService {
	// Admin dashboard
	public AdminDashboardDTO getAdminDashboard();
	
	// Donor dashboard
	public DonorDashboardDTO getDonorDashboard(Long userId);
}

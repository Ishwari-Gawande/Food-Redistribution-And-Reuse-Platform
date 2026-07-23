package com.food.service;

import java.util.List;

import com.food.DTO.AdminDashboardDTO;
import com.food.DTO.DonorDashboardDTO;
import com.food.DTO.ImpactDashboardDTO;
import com.food.DTO.MonthlyStatisticsDTO;

public interface DashboardService {
	// Admin dashboard
	public AdminDashboardDTO getAdminDashboard();

	// Donor dashboard
	public DonorDashboardDTO getDonorDashboard(Long userId);

	// Impact dashboard
	public ImpactDashboardDTO getImpactDashboard();

	// Monthly Statistics
	public List<MonthlyStatisticsDTO> getMonthlyStatistics();
}

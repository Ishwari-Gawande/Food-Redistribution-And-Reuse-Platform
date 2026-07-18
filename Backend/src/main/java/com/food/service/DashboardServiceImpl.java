package com.food.service;

import org.springframework.stereotype.Service;

import com.food.DTO.AdminDashboardDTO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DashboardServiceImpl implements DashboardService{

	@Override
	public AdminDashboardDTO getAdminDashboard() {
		// TODO Auto-generated method stub
		return null;
	}

}

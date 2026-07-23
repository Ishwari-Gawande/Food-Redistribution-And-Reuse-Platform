package com.food.service;

import org.springframework.stereotype.Service;

import com.food.DTO.AdminDashboardDTO;
import com.food.DTO.DonorDashboardDTO;
import com.food.entities.DeliveryStatus;
import com.food.repository.DelieveryRepository;
import com.food.repository.MatchesRepository;
import com.food.repository.RequestRepository;
import com.food.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

	private final UserRepository userRepo;
	private final RequestRepository reqRepo;
	private final MatchesRepository matchRepo;
	private final DelieveryRepository deliveryRepo;

	@Override
	public AdminDashboardDTO getAdminDashboard() {

		AdminDashboardDTO dto = new AdminDashboardDTO();

		dto.setTotalUsers(userRepo.count());

		dto.setPendingUsers(userRepo.countByStatus("PENDING"));

		dto.setTotalRequests(reqRepo.count());

		dto.setPendingRequests(reqRepo.countByStatus("PENDING"));

		dto.setTotalMatches(matchRepo.count());

		dto.setTotalDeliveries(deliveryRepo.count());

		dto.setCompletedDeliveries(deliveryRepo.countByStatus(DeliveryStatus.COMPLETED));

		return dto;
	}

	@Override
	public DonorDashboardDTO getDonorDashboard() {

		DonorDashboardDTO dto = new DonorDashboardDTO();

		return null;
	}

}

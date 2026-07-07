package com.food.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.food.DTO.RequestDTO;
import com.food.Exception.ResourceNotFoundException;
import com.food.entities.Request;
import com.food.entities.User;
import com.food.repository.RequestRepository;
import com.food.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

	private final UserRepository userRepo;
	private final RequestRepository requestRepo;

	@Override
	public String AddNewRequest(RequestDTO dto) {
		
		User user = userRepo.findByEmail(email);

		Request request = new Request();

		request.setRequestType(dto.getRequestType());
		request.setStatus("Draft");
		request.setMealPreference(dto.getMealPreference());
		request.setEstimatedMeals(dto.getEstimatedMeals());
		request.setPickUpAddress(dto.getPickUpAddress());
		request.setDeliveryAvailable(dto.isDeliveryAvailable());
		request.setNeededBy(dto.getNeededBy());
		request.setNotes(dto.getNotes());
		request.setCreatedAt(dto.getCreatedAt().now());
		request.setUser(user);

		return null;
	}

	@Override
	public Request findById(Long id) {
		return requestRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Request not found"));
	}

	@Override
	public List<Request> findAllRequest() {
		return requestRepo.findAll();
	}

}

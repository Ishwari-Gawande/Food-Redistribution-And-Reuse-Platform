package com.food.service;

import org.springframework.stereotype.Service;

import com.food.Exception.ResourceNotFoundException;
import com.food.entities.Request;
import com.food.repository.RequestRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

	private final RequestRepository requestRepo;

	@Override
	public Request findById(Long id) {
		return requestRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Request not found"));
	}

}

package com.food.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.food.Exception.ResourceNotFoundException;
import com.food.entities.Request;
import com.food.entities.RequestItems;
import com.food.repository.RequestItemRepository;
import com.food.repository.RequestRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RequestItemServiceImpl implements RequestItemService {

	private final RequestRepository requestRepo;

	private final RequestItemRepository requestItemRepo;

	@Override
	public RequestItems findById(Long id) {
		return requestItemRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("RequestItem not Found"));
	}

	@Override
	public List<RequestItems> findByRequest(Long requestId) {
		Request request = requestRepo.findById(requestId)
				.orElseThrow(() -> new ResourceNotFoundException("Request Not Found!!"));
		return requestItemRepo.findByRequest(request);
	}
}

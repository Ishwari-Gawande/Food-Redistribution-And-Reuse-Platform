package com.food.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.DTO.RequestDTO;
import com.food.DTO.RequestResponseDTO;
import com.food.service.RequestServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/request")
@RequiredArgsConstructor
public class RequestController {

	private final RequestServiceImpl requestService;

	// add new request
	@PostMapping
	public ResponseEntity<RequestResponseDTO> addNewRequest(@RequestBody RequestDTO dto) {

		RequestResponseDTO response = requestService.AddNewRequest(dto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {

		return ResponseEntity.ok(requestService.findById(id));
	}

	// find all requests
	@GetMapping
	public ResponseEntity<?> findAllRequests() {
		return ResponseEntity.ok(requestService.findAllRequest());
	}
}

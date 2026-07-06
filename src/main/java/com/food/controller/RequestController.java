package com.food.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.service.RequestServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/request")
@RequiredArgsConstructor
public class RequestController {

	private final RequestServiceImpl requestService;

	//find by id
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {

		return ResponseEntity.ok(requestService.findById(id));
	}
}

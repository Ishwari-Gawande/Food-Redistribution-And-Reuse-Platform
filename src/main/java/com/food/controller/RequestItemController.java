package com.food.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.service.RequestItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/request_Item")
@RequiredArgsConstructor
public class RequestItemController {

	private final RequestItemService requestItemService;

	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(long id) {
		return ResponseEntity.ok(requestItemService.findById(id));
	}

	// find by request
	@GetMapping("/request")
	public ResponseEntity<?> findByRequest(Long RequestId) {
		return ResponseEntity.ok(requestItemService.findByRequest(RequestId));
	}
}

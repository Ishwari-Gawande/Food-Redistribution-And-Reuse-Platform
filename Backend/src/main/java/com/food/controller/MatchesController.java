package com.food.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.DTO.AssignDeliveryDTO;
import com.food.DTO.MatchDTO;
import com.food.service.MatchServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchesController {

	private final MatchServiceImpl matchService;

	 @PostMapping
	    public ResponseEntity<?> createMatch(@Valid @RequestBody MatchDTO request) {

	        return ResponseEntity.ok(matchService.createMatch(request));
	    }
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return ResponseEntity.ok(matchService.findById(id));
	}

	@GetMapping
	public ResponseEntity<?> findAllMatches() {
		return ResponseEntity.ok(matchService.findAllMatches());
	}

	@GetMapping("/pending")
	public ResponseEntity<?> findPendingMatches() {

		return ResponseEntity.ok(matchService.findPendingMatches());

	}
	
	@PutMapping("/{id}/approve")
	public ResponseEntity<?> approveMatch(@PathVariable Long id) {

	    return ResponseEntity.ok(matchService.approveMatch(id));

	}
	
	@PutMapping("/{id}/reject")
	public ResponseEntity<?> rejectMatch(@PathVariable Long id) {

	    return ResponseEntity.ok(matchService.rejectMatch(id));

	}
	
	@PutMapping("/{id}/assign-delivery")
	public ResponseEntity<?> assignDeliveryPartner(
	        @PathVariable Long id,
	     @Valid @RequestBody AssignDeliveryDTO request) {

	    return ResponseEntity.ok(
	            matchService.assignDeliveryPartner(id, request));

	}
}

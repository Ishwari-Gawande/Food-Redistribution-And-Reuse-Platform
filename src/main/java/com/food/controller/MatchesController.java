package com.food.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.service.MatchServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchesController {

	private final MatchServiceImpl matchService;

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
}
